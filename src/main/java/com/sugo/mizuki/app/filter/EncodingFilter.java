package com.sugo.mizuki.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * リクエストパラメータの文字エンコードを設定するクラス
 * @author sugou
 *
 */
public class EncodingFilter implements Filter {

    /**
     * {@inheritDoc}
     */
    public void destroy() {
    }

    /**
     * {@inheritDoc}
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("Shift-JIS");
        chain.doFilter(request, response);
    }

    /**
     * {@inheritDoc}
     */
    public void init(FilterConfig config) throws ServletException {
    }
}
