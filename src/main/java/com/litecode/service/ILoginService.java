package com.litecode.service;

import com.dtflys.forest.http.ForestResponse;

/**
 * Description: 用户服务
 *
 * @author peakliuz
 * @since 2023/11/23 10:54:32
 */
public interface ILoginService {

    ForestResponse<Void> login();
}
