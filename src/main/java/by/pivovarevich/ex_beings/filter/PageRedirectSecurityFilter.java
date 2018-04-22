//package by.pivovarevich.ex_beings.filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(urlPatterns = {"/jsp/*"},
//            initParams = {
//            @WebInitParam(name = "indexPath", value = "/index.jsp")
//            })
//public class PageRedirectSecurityFilter implements Filter {
//
//    private String path;
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        path = filterConfig.getInitParameter("indexPath");
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.sendRedirect(request.getContextPath() + path);
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        path = null;
//    }
//}
