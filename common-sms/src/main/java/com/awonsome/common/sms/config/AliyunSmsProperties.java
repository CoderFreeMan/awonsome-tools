package com.awonsome.common.sms.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.aliyun.credentials.Client;

/**
 * @author yangdejun
 * @date 2021/12/29 22:57
 */
@ConfigurationProperties(prefix = "alibaba.cloud.sms")
@Configuration
public class AliyunSmsProperties {

    private String accessKeyId;

    private String accessKeySecret;

    private String securityToken;

    private String protocol;

    private String method;

    private String regionId;

    private Integer readTimeout;

    private Integer connectTimeout;

    private String httpProxy;

    private String httpsProxy;

    private  Client credential;

    private String endpoint;

    private String noProxy;

    private Integer maxIdleConns;

    private String network;

    private String userAgent;

    private String suffix;

    private String socks5Proxy;

    private String socks5NetWork;

    private String endpointType;

    private String openPlatformEndpoint;

    private String signatureVersion;

    private String signatureAlgorithm;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Integer readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Integer connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public String getHttpProxy() {
        return httpProxy;
    }

    public void setHttpProxy(String httpProxy) {
        this.httpProxy = httpProxy;
    }

    public String getHttpsProxy() {
        return httpsProxy;
    }

    public void setHttpsProxy(String httpsProxy) {
        this.httpsProxy = httpsProxy;
    }

    public Client getCredential() {
        return credential;
    }

    public void setCredential(Client credential) {
        this.credential = credential;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getNoProxy() {
        return noProxy;
    }

    public void setNoProxy(String noProxy) {
        this.noProxy = noProxy;
    }

    public Integer getMaxIdleConns() {
        return maxIdleConns;
    }

    public void setMaxIdleConns(Integer maxIdleConns) {
        this.maxIdleConns = maxIdleConns;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSocks5Proxy() {
        return socks5Proxy;
    }

    public void setSocks5Proxy(String socks5Proxy) {
        this.socks5Proxy = socks5Proxy;
    }

    public String getSocks5NetWork() {
        return socks5NetWork;
    }

    public void setSocks5NetWork(String socks5NetWork) {
        this.socks5NetWork = socks5NetWork;
    }

    public String getEndpointType() {
        return endpointType;
    }

    public void setEndpointType(String endpointType) {
        this.endpointType = endpointType;
    }

    public String getOpenPlatformEndpoint() {
        return openPlatformEndpoint;
    }

    public void setOpenPlatformEndpoint(String openPlatformEndpoint) {
        this.openPlatformEndpoint = openPlatformEndpoint;
    }

    public String getSignatureVersion() {
        return signatureVersion;
    }

    public void setSignatureVersion(String signatureVersion) {
        this.signatureVersion = signatureVersion;
    }

    public String getSignatureAlgorithm() {
        return signatureAlgorithm;
    }

    public void setSignatureAlgorithm(String signatureAlgorithm) {
        this.signatureAlgorithm = signatureAlgorithm;
    }

    @Override
    public String toString() {
        return "AliyunSmsProperties{" +
                "accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", securityToken='" + securityToken + '\'' +
                ", protocol='" + protocol + '\'' +
                ", method='" + method + '\'' +
                ", regionId='" + regionId + '\'' +
                ", readTimeout=" + readTimeout +
                ", connectTimeout=" + connectTimeout +
                ", httpProxy='" + httpProxy + '\'' +
                ", httpsProxy='" + httpsProxy + '\'' +
                ", credential=" + credential +
                ", endpoint='" + endpoint + '\'' +
                ", noProxy='" + noProxy + '\'' +
                ", maxIdleConns=" + maxIdleConns +
                ", network='" + network + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", suffix='" + suffix + '\'' +
                ", socks5Proxy='" + socks5Proxy + '\'' +
                ", socks5NetWork='" + socks5NetWork + '\'' +
                ", endpointType='" + endpointType + '\'' +
                ", openPlatformEndpoint='" + openPlatformEndpoint + '\'' +
                ", signatureVersion='" + signatureVersion + '\'' +
                ", signatureAlgorithm='" + signatureAlgorithm + '\'' +
                '}';
    }
}
