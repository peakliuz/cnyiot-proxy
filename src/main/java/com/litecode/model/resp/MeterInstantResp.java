package com.litecode.model.resp;

import lombok.Data;

/**
 * MeterInstantResp
 *
 * @author peakliuz
 * @since 2024/3/7 22:01
 */
@Data
public class MeterInstantResp {

    /**
     * 总电量
     */
    private double tkwh;
    /**
     * 表内剩余
     */
    private double ekwh;

    /**
     * 其它参数
     */
    private OtherParam otherParam_1p;

    @Data
   public static class OtherParam {
        /**
         * 电流
         */
        private double cur;
        /**
         * 电压
         */
        private double vol;
        /**
         * 功率因素
         */
        private double pf;
    }

}
