package com.nhnacademy.student.filter;


import javax.servlet.FilterConfig;
import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws SecurityException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(this.encoding);
        resp.setCharacterEncoding(this.encoding);
        chain.doFilter(req, resp);

    }
}
