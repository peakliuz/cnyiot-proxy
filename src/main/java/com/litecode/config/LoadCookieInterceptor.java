package com.litecode.config;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestCookie;
import com.dtflys.forest.http.ForestCookies;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.interceptor.Interceptor;
import com.litecode.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description:
 *
 * @author peakliuz
 * @since 2023/11/23 11:58:04
 */
@Slf4j
@Component
public class LoadCookieInterceptor<T> implements Interceptor<T> {

    @Resource
    private ILoginService userService;

    private Map<String, List<ForestCookie>> cookieCache = new ConcurrentHashMap<>();

    /**
     * 在发送请求前，需要加载Cookie时调用该方法
     *
     * @param request Forest请求对象
     * @param cookies Cookie集合, 需要通过请求发送的Cookie都添加到该集合
     */
    @Override
    public void onLoadCookie(ForestRequest request, ForestCookies cookies) {
        // 获取请求URI的主机名
        String host = request.getURI().getHost();
        // 从缓存中获取之前获得的Cookie列表，主机名作为Key
        List<ForestCookie> cookieList = cookieCache.get(host);
        cookies.addAllCookies(cookieList);
    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {
        log.error("接口{}请求失败", request.getUrl());
    }

    @Override
    public void onRetry(ForestRequest request, ForestResponse response) {
        ForestResponse<Void> forestResponse = userService.login();
        List<ForestCookie> cookies = forestResponse.getCookies();
        request.addCookies(cookies);
        // 获取请求URI的主机名
        String host = request.getURI().getHost();
        // 将从服务端获得的Cookie列表放入缓存，主机名作为Key
        cookieCache.put(host, cookies);
    }


}


