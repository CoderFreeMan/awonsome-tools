package com.awonsome.common.sms.service;

import cn.hutool.json.JSONUtil;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.*;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 短信服务
 * @author yangdejun
 * @date 2022/1/3 22:27
 */
@Service
public class SmsService {

    private final Client smsClient;

    private StringRedisTemplate stringRedisTemplate;

    public SmsService(Client smsClient, StringRedisTemplate stringRedisTemplate) {
        this.smsClient = smsClient;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 发送短信验证码
     * @param smsRequest
     * @return
     */
    public SendSmsResponse sendCode(SendSmsRequest smsRequest, String code) throws Exception {
        stringRedisTemplate.opsForValue().set(smsRequest.getTemplateCode() + "_" + smsRequest.getPhoneNumbers(), code);
        if (Objects.isNull(smsRequest.getTemplateParam())) {
            Map<String, String> params = new HashMap<>(2);
            params.put("code", code);
            smsRequest.setTemplateParam(JSONUtil.toJsonStr(params));
        }
        return sendSms(smsRequest);
    }

    /**
     * 发送普通短信
     * @param smsRequest
     * @return
     * @throws Exception
     */
    public SendSmsResponse sendSms(SendSmsRequest smsRequest) throws Exception {
        return smsClient.sendSms(smsRequest);
    }

    /**
     * 批量发送短信
     * @param batchSmsRequest
     * @return
     * @throws Exception
     */
    public SendBatchSmsResponse sendBatchSms(SendBatchSmsRequest batchSmsRequest) throws Exception {
        return smsClient.sendBatchSms(batchSmsRequest);
    }

    /**
     * 查看短信发送记录和发送状态
     * @param querySendDetailsRequest
     * @return
     * @throws Exception
     */
    public QuerySendDetailsResponse querySendDetails(QuerySendDetailsRequest querySendDetailsRequest) throws Exception {
        return smsClient.querySendDetails(querySendDetailsRequest);
    }

    /**
     * 检查短信是否还在有效期内。
     * 距离短信失效时间大于等于 1 分钟时返回 true，
     * 短信已失效或距离失效时间小于 1 分钟时返回 false。
     * @return true: 有效；false: 失效
     */
    public boolean checkValidity(SendSmsRequest smsRequest) {
        Long expire = stringRedisTemplate.getExpire(smsRequest.getTemplateCode() + smsRequest.getPhoneNumbers(), TimeUnit.SECONDS);
        if (Objects.nonNull(expire) && expire >= 1) {
            return true;
        }
        return false;
    }

}
