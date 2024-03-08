package com.litecode.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * AuthFilter
 *
 * @author peakliuz
 * @since 2024/3/7 21:00
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Resource
    private PropertiesConfig propertiesConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean isLogin = false;

        Map<String, String> uriVar = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        if (uriVar != null && propertiesConfig.getKey().equals(uriVar.get("key"))) {
            isLogin = true;
        }
        if (!isLogin) {
            response.setContentType("application/json;charset=UTF-8");
            //设置编码格式
            response.setCharacterEncoding("UTF-8");
            response.setStatus(401);
            response.getWriter().write("调用出错!");
        }
        return isLogin;
    }
}
