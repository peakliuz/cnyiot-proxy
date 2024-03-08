package com.litecode.model.req;

import lombok.Data;

/**
 * Description:
 *
 * @author peakliuz
 * @since 2023/11/23 12:17:00
 */
@Data
public class ViewReq {

    private String datatime;

    private Integer mType;

    private Integer mYMD;

    private String metID;
}
