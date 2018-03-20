//package com.parawan.authorisation;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//import static com.parawan.servlets.loginservlets.GoogleLoginServlet.USER_NAME;
//
//@WebFilter("parawan/*")
//public class LoginFilter implements Filter {
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) servletRequest;
//        HttpServletResponse res = (HttpServletResponse) servletResponse;
//        String uri = req.getRequestURI();
//
//        HttpSession session = req.getSession();
//
//        if (session.getAttribute(USER_NAME) == null && !uri.endsWith("login")) {
//            res.sendRedirect("login");
//        } else {
//            filterChain.doFilter(servletRequest, servletResponse);
//        }
//
//    }
//
//    @Override
//    public void destroy() {
//    }
//}