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
        filterName = "MakeReservationHourReservationFilter",
        urlPatterns = {"/parawan/make-reservation-next"}
)

public class MakeReservationHourReservationFilter extends IntegerValidator implements Filter {
    private static final Logger LOG = LoggerFactory.getLogger(MakeReservationHourReservationFilter.class);

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
            httpResponse.sendRedirect("/parawan/make-reservation?status=9");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }


    @Override
    public void destroy() {

    }
}