package com.litecode.client;

import com.dtflys.forest.annotation.Address;
import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.http.ForestResponse;

/**
 * Description: 用户客户端
 *
 * @author peakliuz
 * @since 2023/11/23 11:01:19
 */
@Address(host = "www.cnyiot.com", port = "80")
public interface LoginClient {

    @Post(url = "/mlogin.aspx?Method=login",
            contentType = "application/json;charset=UTF-8")
    ForestResponse<Void> login(@Body("un") String username, @Body("pw") String password);

}
