package com.litecode;

import com.litecode.client.MeterClient;
import com.litecode.model.req.MeterListReq;
import com.litecode.model.req.ViewReq;
import com.litecode.model.resp.MeterResp;
import com.litecode.model.resp.Result;
import com.litecode.model.resp.ViewResp;
import com.litecode.service.ILoginService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 测试用户
 *
 * @author peakliuz
 * @since 2023/11/23 11:17:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TestUser {

    @Resource
    private ILoginService userService;

    @Resource
    private MeterClient meterClient;

    @Test
    public void testLogin(){
        userService.login();
        System.out.println("===================");
    }

    @Test
    public void getView(){
        ViewReq viewReq = new ViewReq();
        viewReq.setDatatime("2024-03-05");
        viewReq.setMType(0);
        viewReq.setMYMD(2);
        viewReq.setMetID("19100547827");
        Result<ViewResp> view = meterClient.getView(viewReq);
        ViewResp value = view.getValue();
        log.info("=========={}",value);
    }

    @Test
    public void testMeter(){
        MeterListReq meterListReq = new MeterListReq();
        meterListReq.setGroup(-10);

        List<MeterResp> meterList = meterClient.getMeterList(meterListReq);
        log.info("=========={}",meterList);
    }
}
