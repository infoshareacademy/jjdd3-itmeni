package com.parawan.filters;


import com.parawan.model.ActualBeach;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(
        filterName = "NoBeachSelectedFilter",
        urlPatterns = {"/parawan/*"})
public class NoBeachSelectedFilter implements Filter {

    @Inject
    private ActualBeach actualBeach;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        if (actualBeach.getId() == null
                || actualBeach.getName() == null
                || actualBeach.getMaxHeight() == null
                || actualBeach.getMaxWidth() == null) {
            httpServletResponse.sendRedirect("/login");
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
