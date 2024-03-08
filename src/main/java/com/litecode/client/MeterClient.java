package com.litecode.client;

import com.dtflys.forest.annotation.*;
import com.litecode.config.CustomSuccessCondition;
import com.litecode.config.LoadCookieInterceptor;
import com.litecode.model.req.MeterIdReq;
import com.litecode.model.req.MeterListReq;
import com.litecode.model.req.ViewReq;
import com.litecode.model.resp.MeterInstantResp;
import com.litecode.model.resp.MeterResp;
import com.litecode.model.resp.Result;
import com.litecode.model.resp.ViewResp;

import java.util.List;

/**
 * Description: 电表客户端
 *
 * @author peakliuz
 * @since 2023/11/23 18:38:04
 */
@Address(host = "www.cnyiot.com", port = "80")
@Success(condition = CustomSuccessCondition.class)
public interface MeterClient {


    /**
     * 获取月份视图
     */
    @Post(url = "/Mindex.aspx?Method=getView",
            contentType = "application/json;charset=UTF-8",
            interceptor = LoadCookieInterceptor.class)
    Result<ViewResp> getView(@Body ViewReq req);

    /**
     * 获取电表列表
     */
    @Post(url = "/MManage.aspx?Method=load",
            contentType = "application/x-www-form-urlencoded",
            interceptor = LoadCookieInterceptor.class)
    List<MeterResp> getMeterList(@FormBody MeterListReq req);

    /**
     * 获取电表瞬时信息
     */
    @Post(url = "/MManage.aspx?Method=ReadInstant",
            contentType = "application/json;charset=UTF-8",
            interceptor = LoadCookieInterceptor.class)
    Result<MeterInstantResp> getMeterInstant(@Body MeterIdReq req);


}
