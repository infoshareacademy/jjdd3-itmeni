package com.parawan.filters;


import com.parawan.model.ActualBeach;
import com.parawan.model.UserSession;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "IsLoggedChecker",
        urlPatterns = {"/parawan/*"})
public class IsLoggedChecker implements Filter {

    @Inject
    private UserSession userSession;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (userSession.isLogged() != true) {
            httpServletResponse.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
