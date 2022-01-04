package com.awesome.redis.redisson;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Objects;

/**
 * @author yangdejun
 * @date 2021/12/30 23:09
 */
@ConfigurationProperties(prefix = "redisson")
public class RedissonProperties {

    private String serverAddress;

    private String port;

    private String password;

    private Integer database;

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDatabase() {
        if (Objects.isNull(database)) {
            return 0;
        }
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    @Override
    public String toString() {
        return "RedissonProperties{" +
                "serverAddress='" + serverAddress + '\'' +
                ", port='" + port + '\'' +
                ", password='" + password + '\'' +
                ", database=" + database +
                '}';
    }
}
