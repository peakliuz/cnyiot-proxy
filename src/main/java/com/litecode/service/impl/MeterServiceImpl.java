package com.litecode.service.impl;

import cn.hutool.core.date.DateUtil;
import com.litecode.client.MeterClient;
import com.litecode.config.PropertiesConfig;
import com.litecode.model.req.MeterIdReq;
import com.litecode.model.req.MeterListReq;
import com.litecode.model.req.ViewReq;
import com.litecode.model.resp.MeterInstantResp;
import com.litecode.model.resp.MeterResp;
import com.litecode.model.resp.Result;
import com.litecode.model.resp.ViewResp;
import com.litecode.model.vo.MeterInstantVo;
import com.litecode.model.vo.MeterVo;
import com.litecode.service.IMeterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.hutool.core.date.DatePattern.NORM_MONTH_PATTERN;

/**
 * MeterServiceImpl
 *
 * @author peakliuz
 * @since 2024/3/7 21:21
 */
@Service
public class MeterServiceImpl implements IMeterService {


    @Resource
    private MeterClient meterClient;

    @Resource
    private PropertiesConfig propertiesConfig;


    @Override
    public MeterVo meterInfo() {
        MeterListReq meterListReq = new MeterListReq();
        meterListReq.setGroup(-10);
        List<MeterResp> meterList = meterClient.getMeterList(meterListReq);
        MeterResp meterResp = meterList.get(0);
        return MeterVo.builder()
                .name(meterResp.getName())
                .status(meterResp.getMet_status())
                .temper(meterResp.getTemper())
                .warmKwh(meterResp.getWarmKwh())
                .price(meterResp.getPrice())
                .remainKwh(meterResp.getS_enablekwh())
                .totalKwh(meterResp.getTotalkwh())
                .build();
    }

    @Override
    public MeterInstantVo getMeterInstant() {
        Result<MeterInstantResp> meterInstant = meterClient.getMeterInstant(new MeterIdReq(propertiesConfig.getUsername()));
        MeterInstantResp value = meterInstant.getValue();
        MeterInstantResp.OtherParam otherParam = value.getOtherParam_1p();
        return MeterInstantVo.builder()
                .totalKwh(value.getTkwh())
                .remainKwh(value.getEkwh())
                .current(otherParam.getCur())
                .voltage(otherParam.getVol())
                .factor(otherParam.getPf())
                .power(otherParam.getCur() * otherParam.getVol() * otherParam.getPf()).build();
    }

    @Override
    public Map<Integer, Double> meterMonthInfo() {
        ViewReq viewReq = new ViewReq();
        String date = DateUtil.format(new Date(), NORM_MONTH_PATTERN);
        viewReq.setDatatime(date + "-01");
        viewReq.setMType(0);
        viewReq.setMYMD(2);
        viewReq.setMetID(propertiesConfig.getUsername());
        Result<ViewResp> view = meterClient.getView(viewReq);
        ViewResp value = view.getValue();
        List<Integer> xAxisData = value.getXAxisData();
        List<List<Double>> seriesData = value.getSeriesData();
        Map<Integer, Double> resultMap = new HashMap<>();
        for (int i = 0; i < xAxisData.size(); i++) {
            resultMap.put(xAxisData.get(i), seriesData.get(0).get(i));
        }
        return resultMap;
    }
}
