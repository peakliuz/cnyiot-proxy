package com.litecode.model.resp;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * Description:
 *
 * @author peakliuz
 * @since 2023/11/23 18:22:18
 */
@Data
public class ViewResp {

    @JSONField(name = "series_data")
    private List<List<Double>> seriesData;

    @JSONField(name = "series_name")
    private List<String> seriesName;

    @JSONField(name = "xAxis_data")
    private List<Integer> xAxisData;

    @JSONField(name = "xAxis_name")
    private String xAxisName;
}
