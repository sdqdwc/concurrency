package com.mw.concurrency;

import com.mw.concurrency.example.threadLocal.RequestHolder;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author WangCH
 * @create 2018-03-21 23:57
 */
@Slf4j
public class HttpFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info("do filter,{},{}",Thread.currentThread().getId(),request.getServletPath());
        //request.getSession().getAttribute("user");
        RequestHolder.add(Thread.currentThread().getId());
        filterChain.doFilter(servletRequest,servletResponse);
        //这里会开始执行拦截器
        log.info("过滤结束");
        //拦截器处理 RequestHolder.remove();
    }

    @Override
    public void destroy() {

    }
}
