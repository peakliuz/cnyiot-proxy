package com.litecode.model.req;

import lombok.Data;

/**
 * Description: 电表列表请求类
 *
 * @author peakliuz
 * @since 2023/11/23 19:12:40
 */
@Data
public class MeterListReq {

    private Integer group;

    private String ckv;
}
