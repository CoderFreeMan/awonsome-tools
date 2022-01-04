package com.awonsome.common.sms.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangdejun
 * @date 2021/12/30 13:25
 */
@EnableConfigurationProperties(value = AliyunSmsProperties.class)
@Configuration
public class SmsClient {

    private final AliyunSmsProperties aliyunSmsProperties;

    public SmsClient(AliyunSmsProperties aliyunSmsProperties) {
        this.aliyunSmsProperties = aliyunSmsProperties;
    }

    @Bean
    public Client client() throws Exception {
        Config config = new Config();
        config.setAccessKeyId(aliyunSmsProperties.getAccessKeyId());
        config.setAccessKeySecret(aliyunSmsProperties.getAccessKeySecret());
        config.setConnectTimeout(aliyunSmsProperties.getConnectTimeout());
        config.setEndpoint(aliyunSmsProperties.getEndpoint());
        config.setMaxIdleConns(aliyunSmsProperties.getMaxIdleConns());
        config.setReadTimeout(aliyunSmsProperties.getReadTimeout());
        Client client = new Client(config);
        return client;
    }

}
