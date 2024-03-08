package com.litecode.model.vo;

import lombok.Builder;
import lombok.Data;

/**
 * MeterVo
 *
 * @author peakliuz
 * @since 2024/3/7 21:18
 */
@Data
@Builder
public class MeterVo {

    /**
     * 电表名称
     */
    private String name;

    /**
     * 电表状态 在线(通电)
     */
    private String status;

    /**
     * 电表温度
     */
    private double temper;

    /**
     * 报警电量
     */
    private double warmKwh;

    /**
     * 价格
     */
    private double price;

    /**
     * 剩余电量
     */
    private double remainKwh;

    /**
     * 总电量
     */
    private double totalKwh;


}
