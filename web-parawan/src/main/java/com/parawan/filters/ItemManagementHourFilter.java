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


@WebFilter(
        filterName = "ItemManagementHourFilter",
        urlPatterns = {"/parawan/item-management"}
)
public class ItemManagementHourFilter extends IntegerValidator implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(ItemManagementHourFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        boolean isValidationOK = true;
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        List<String> messages = new ArrayList<>();

        if (!isIntegerParameterValid("hourFromForm", httpRequest)) {
            messages.add(UserOperationsMessages.HOUR_NOT_INTEGER);
            isValidationOK = false;
        } else if (!isHourIntegerParameterInScope("hourFromForm", httpRequest)) {
            messages.add(UserOperationsMessages.CLOSED);
            isValidationOK = false;
        }

        if (!isValidationOK) {
            httpRequest.getSession().setAttribute("errors", messages);
            httpResponse.sendRedirect("/parawan/item-management?hourFromForm=9");
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
    }
}