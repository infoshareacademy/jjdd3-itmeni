package com.parawan.filters;

import com.parawan.com.menu.CancelReservation;
import com.parawan.messages.CancelOperationsMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(
        filterName = "CancelReservationValidationFilter",
        urlPatterns = {"/parawan/cancel-reservation"}
        )

public class CancelReservationValidationFilter implements Filter{

    private static final Logger LOG = LoggerFactory.getLogger(CancelReservationValidationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException{
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        CancelReservation cancelReservation = getCancelObject(httpRequest);
        List<String> messages = new ArrayList<> ();

        String idParameter = httpRequest.getParameter("cancelId");
        String hourParameter = httpRequest.getParameter("cancelHour");

        if (!isIntegerParameterValid("cancelId", httpRequest)) {
            messages.add(CancelOperationsMessages.ID_NOT_INTEGER);
            isValidationOK = false;
        } else if (idParameter != null && !idParameter.isEmpty()) {
            cancelReservation.setCancelId (Integer.parseInt(idParameter));
        } else {
            messages.add (CancelOperationsMessages.ID_OUT_OF_RANGE);
        }

        if (!isIntegerParameterValid("cancelHour", httpRequest)) {
            messages.add(CancelOperationsMessages.HOUR_NOT_INTEGER);
            isValidationOK = false;
        } else if (hourParameter != null && !hourParameter.isEmpty()) {
            cancelReservation.setCancelHour (Integer.parseInt(httpRequest.getParameter("cancelHour")));
        } else {
            messages.add (CancelOperationsMessages.HOUR_OUT_OF_RANGE);
        }

        if (!isValidationOK) {
            httpRequest.getSession().setAttribute("errors", messages);
            httpRequest.getSession().setAttribute("cancelReservation", cancelReservation);
            httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private CancelReservation getCancelObject(HttpServletRequest servletRequest) {
        CancelReservation cancelReservation = new CancelReservation ();
        cancelReservation.setCancelId (null);
        cancelReservation.setCancelHour (null);
        return cancelReservation;
    }

    private boolean isIntegerParameterValid(String parameterKey, HttpServletRequest servletRequest) {

        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        LOG.debug ("{}",String.valueOf(isPost));

        if (parameter == null || parameter.isEmpty()) {
            return !isPost;
        }

        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(parameter);

        if (!matcher.matches()) {
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {
    }

}
