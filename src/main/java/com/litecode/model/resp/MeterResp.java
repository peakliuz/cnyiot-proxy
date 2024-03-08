package com.litecode.model.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * Description: 电表相应类
 *
 * @author peakliuz
 * @since 2023/11/23 19:14:01
 */
@Data
public class MeterResp {

    private long MeterID;
    private int PriceID;
    private int PriceMul;
    private String Name;
    private String Tel;
    private String Note;
    private int iswifimeter;
    private int warmKwh;
    private long powerGate;
    private long UserID;
    private int MeterType;
    private int SellMin;
    private int ratio;
    private int MeterModel;
    private int group;
    private int gtOn;
    private int gtOff;
    private int volH;
    private int volL;
    private int priceInMet;
    private String priceN;
    private String PriceName;
    private int Price;
    private int PriceOth;
    private int PriceOth2;
    private String PriceOthN;
    private String PriceOthN2;
    private double s_enablekwh;
    private Date s_datetime;
    private int s_rs;

    /**
     * 总用电量
     */
    @JSONField(name = "s_totalkwh")
    private Double totalkwh;
    private int temper;
    private int steal;
    private int tswitch;
    private String mversion;
    private int tom;
    private int enm;
    private int mprice;
    private int canblue;
    private String userName;
    private String userLogid;
    private String pmnm;
    private String pmtp;
    private String concenid;
    private String result;
    private String type;
    private String T_Status;
    private String met_status;
    private String met_timespan;
    private String typeName;
    private String isLovest;
    private int s;
    private int iscon;
    private int othflag;
}
