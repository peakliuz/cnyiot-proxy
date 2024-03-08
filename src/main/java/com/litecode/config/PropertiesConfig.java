package com.litecode.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description: 配置类
 *
 * @author peakliuz
 * @since 2023/11/23 15:38:32
 */
@Data
@Component
@ConfigurationProperties(prefix = "cnyiot")
public class PropertiesConfig {

    private String username;

    private String password;

    private String key;
}
