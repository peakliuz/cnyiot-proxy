package com.litecode.config;

import com.dtflys.forest.callback.SuccessWhen;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestResponse;
import org.springframework.stereotype.Component;

/**
 * Description: 自定义成功/失败条件
 *
 * @author peakliuz
 * @since 2023/11/23 13:13:58
 */
@Component
public class CustomSuccessCondition implements SuccessWhen {

    /**
     * 请求成功条件
     * @param req Forest请求对象
     * @param res Forest响应对象
     * @return 是否成功，true: 请求成功，false: 请求失败
     */
    @Override
    public boolean successWhen(ForestRequest req, ForestResponse res) {

        // req 为Forest请求对象，即 ForestRequest 类实例
        // res 为Forest响应对象，即 ForestResponse 类实例
        // 返回值为 ture 则表示请求成功，false 表示请求失败
        return res.noException() &&   // 请求过程没有异常
                res.statusOk() &&     // 并且状态码在 100 ~ 399 范围内
                res.statusIsNot(203) &&
                !res.getContent().contains("loginout")&&// 不包含loginout
                !res.getContent().contains("请求过于频繁"); // 不包含请求过于频繁
        // 当然在这里也可以写其它条件，比如 通过 res.getResult() 或 res.getContent() 获取业务数据
        // 再根据业务数据判断是否成功
    }
}