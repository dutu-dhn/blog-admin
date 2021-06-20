package com.dutu.admin.config;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author dutu
 * @date 2021-04-26 21:03
 */
@Configuration
@PropertySource(value = {"classpath:application.yaml"})
@ConfigurationProperties(prefix = "aliyun")
@Data
public class AliyunConfig {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
    private String urlPrefix;

    @Bean
    public OSS oSSClient() {
        return new OSSClient(endpoint, accessKeyId, accessKeySecret);
    }
}

