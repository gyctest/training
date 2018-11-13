package com.demo.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 描述:
 * <p>
 *
 * @author gyc
 * @version 1.0
 * @date 2018/11/13 0013
 */
public class DemoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Demo DemoFilter.init() xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Demo DemoFilter.doFilter() xxxxxxxxxxxxxxxxxxxxxxxxxx");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxx Demo DemoFilter.destroy() xxxxxxxxxxxxxxxxxxxxxxxxxx");
    }
}
