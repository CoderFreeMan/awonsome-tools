package com.awonsome.common.sms.service;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author yangdejun
 * @date 2021/12/29 23:01
 */
@Service
public class AliyunSmsService {

    private final Client client;

    private final RedisTemplate<String, String> redisTemplate;

    public AliyunSmsService(Client client, RedisTemplate<String, String> redisTemplate) {
        this.client = client;
        this.redisTemplate = redisTemplate;
    }

    public void sendMessage() throws Exception {
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers("18937671061");
        request.setSignName("合生活");
        request.setTemplateCode("SMS_230960350");
        SendSmsResponse sendSmsResponse = client.sendSms(request);
        redisTemplate.opsForValue().set("sms", "success");
    }
}
