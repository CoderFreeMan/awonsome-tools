package com.awesome.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @author yangdejun
 * @date 2021/12/30 23:14
 */
@EnableConfigurationProperties(RedissonProperties.class)
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient(RedissonProperties properties) {
        if (Objects.isNull(properties.getServerAddress())) {
            return null;
        }
        Config config = new Config();
        SingleServerConfig singleServerConfig = config.useSingleServer();
        singleServerConfig.setAddress(properties.getServerAddress() + ":" + properties.getPort());
        singleServerConfig.setDatabase(properties.getDatabase());
        String password = properties.getPassword();
        if (!StringUtils.isEmpty(password)) {
            singleServerConfig.setPassword(password);
        }
        return Redisson.create(config);
    }
}
