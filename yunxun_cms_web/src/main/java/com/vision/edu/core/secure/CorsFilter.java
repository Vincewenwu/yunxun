package com.vision.edu.core.secure;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Allow access for
 * Created by Nandy on 2016/12/26.
 */
public class CorsFilter implements Filter {

    private String allowOrigin;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.allowOrigin = filterConfig.getInitParameter("allowOrigin");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Access-Control-Max-Age", "1209600");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, OPTIONS, DELETE");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("Access-Control-Allow-Origin", allowOrigin);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
