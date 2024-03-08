package com.litecode.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * MeterInstantResp
 *
 * @author peakliuz
 * @since 2024/3/7 22:01
 */
@Data
@Builder
public class MeterInstantVo {

    /**
     * 总电量
     */
    private double totalKwh;
    /**
     * 表内剩余电量
     */
    private double remainKwh;

    /**
     * 电流
     */
    private double current;
    /**
     * 电压
     */
    private double voltage;
    /**
     * 功率因素
     */
    private double factor;

    /**
     * 功率
     */
    private double power;

}
