package com.litecode.model.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 电表列表请求类
 *
 * @author peakliuz
 * @since 2023/11/23 19:12:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MeterIdReq {

    private String metid;
}
