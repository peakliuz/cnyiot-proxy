package com.litecode.model.resp;

import lombok.Data;

/**
 * Description: 公共返回结果值
 *
 * @author peakliuz
 * @since 2023/11/23 18:18:53
 */
@Data
public class Result<T> {

    private String result;

    private T value;
}
