package com.litecode.service.impl;

import com.dtflys.forest.http.ForestResponse;
import com.litecode.client.LoginClient;
import com.litecode.config.PropertiesConfig;
import com.litecode.service.ILoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description: 用户服务实现类
 *
 * @author peakliuz
 * @since 2023/11/23 10:54:52
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Resource
    private LoginClient loginClient;
    @Resource
    private PropertiesConfig propertiesConfig;

    @Override
    public ForestResponse<Void> login() {
        return loginClient.login(propertiesConfig.getUsername(), propertiesConfig.getPassword());
    }
}
