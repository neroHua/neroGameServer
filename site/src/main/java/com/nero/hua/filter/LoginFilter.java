package com.nero.hua.filter;

import com.alibaba.fastjson.JSON;
import com.nero.hua.config.LoginFilterConfig;
import com.nero.hua.constant.LoginConstant;
import com.nero.hua.enumeration.LoginEnumeration;
import com.nero.hua.model.base.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@Component
@WebFilter(filterName="LoginValidateFilter", urlPatterns="/*")
public class LoginFilter implements Filter {

    @Autowired
    LoginFilterConfig loginFilterConfig;

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();

        if (loginFilterConfig.exclude(requestURI)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        HttpSession httpSession = ((HttpServletRequest) servletRequest).getSession();
        if(null != httpSession.getAttribute(LoginConstant.LOGIN)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        servletResponse.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        servletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        BaseResponse<?> baseResponse = new BaseResponse<>(LoginEnumeration.NEED_LOGIN.getCode(), LoginEnumeration.NEED_LOGIN.getMessage());
        OutputStream outputStream = servletResponse.getOutputStream();
        String baseResponseString = JSON.toJSONString(baseResponse);
        outputStream.write(baseResponseString.getBytes());
        outputStream.flush();
    }

    @Override
    public void destroy() {
    }

}
