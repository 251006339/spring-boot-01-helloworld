package com.hxm.springboot01helloworld.filter;


import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author XAIOHU
 * @date 2019/9/10 --17:40
 **/
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {

    }
}
