package com.parawan.filters;

import com.parawan.model.Reservation;
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
        urlPatterns = {"/make-reservation"}
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



    }

    private Reservation getReservationObject(HttpServletRequest servletRequest) {
        Reservation reservation = new Reservation();

    }

    @Override
    public void destroy() {

    }
}
