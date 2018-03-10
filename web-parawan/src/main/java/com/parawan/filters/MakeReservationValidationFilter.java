package com.parawan.filters;

import com.parawan.messages.UserOperationsMessages;
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
        filterName = "MakeReservationValidationFilter",
        urlPatterns = {"/parawan/make-reservation-next"}
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
        List<String> messages = new ArrayList<>();

        if(!isIntegerParameterValid("chosenHour", httpRequest)){
            messages.add(UserOperationsMessages.HOUR_NOT_INTEGER);
            isValidationOK = false;
        }

        else if(!isIntegerParameterInScope("chosenHour", httpRequest)){
            messages.add(UserOperationsMessages.CLOSED);
            isValidationOK = false;
        }

        if(!isValidationOK){
            httpRequest.getSession().setAttribute("errors", messages);
            httpResponse.sendRedirect("/parawan/make-reservation");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean isIntegerParameterValid (String parameterKey, HttpServletRequest servletRequest){
        String parameter = servletRequest.getParameter(parameterKey);
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        boolean isGet = httpRequest.getMethod().equalsIgnoreCase("get");

        if (parameter == null || parameter.isEmpty()){
            return !isGet;
        }

        Pattern integerPattern = Pattern.compile("\\d+");
        Matcher matcher = integerPattern.matcher(parameter);

        if(!matcher.matches()){
            return false;
        }

        return true;
    }

    private boolean isIntegerParameterInScope(String parameterKey, HttpServletRequest servletRequest){
        int parameter =Integer.parseInt(servletRequest.getParameter(parameterKey));
        if(parameter>8 && parameter <19){
            return true;
        }
        return false;
    }

    @Override
    public void destroy() {

    }
}
