package com.parawan.filters;

import com.parawan.messages.UserOperationsMessages;
import com.parawan.model.Reservation;
import com.parawan.servlets.CancelReservationServlet;
import com.parawan.servlets.MainMenuServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter(
        filterName = "MakeReservationValidationFilter",
        urlPatterns = {"/parawan/make-reservation"}
)

public class MakeReservationValidationFilter implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationValidationFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        Reservation reservation = getReservationObject(httpRequest);
        List<String> messages = new ArrayList<>();

        String hourParameter = httpRequest.getParameter("chosenHour");

        if(!isIntegerParameterValid("chosenHour", httpRequest)){
            messages.add(UserOperationsMessages.HOUR_NOT_INTEGER);
            isValidationOK = false;
        }
        else if(hourParameter != null && !hourParameter.isEmpty()){
            reservation.setPlaceId(Integer.parseInt(hourParameter));
        }

        if(!isValidationOK){
            httpRequest.getSession().setAttribute("errors", messages);
            httpResponse.sendRedirect(httpRequest.getRequestURL().toString());
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);

    }

    private Reservation getReservationObject(HttpServletRequest servletRequest) {
        Reservation reservation = new Reservation();

        reservation.setHourOfReservation(null);

        return reservation;
    }

    private boolean isIntegerParameterValid (String parameterKey, HttpServletRequest servletRequest){
        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isPost = httpRequest.getMethod().equalsIgnoreCase("post");

        final Logger LOG = LoggerFactory.getLogger(MakeReservationValidationFilter.class);

        if (parameter == null || parameter.isEmpty()){
            return !isPost;
        }

        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(parameter);

        if(!matcher.matches()){
            return false;
        }

        return true;
    }

    @Override
    public void destroy() {

    }
}
