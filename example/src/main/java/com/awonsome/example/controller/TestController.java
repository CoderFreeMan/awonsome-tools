package com.awonsome.example.controller;

import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.awonsome.common.sms.service.SmsService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangdejun
 * @date 2021/12/31 22:24
 */
@RestController
@RequestMapping(value = "/redis")
public class TestController {

    private final RedisTemplate<String, String> redisTemplate;

    private final SmsService smsService;


    public TestController(RedisTemplate<String, String> redisTemplate, SmsService smsService) {
        this.redisTemplate = redisTemplate;
        this.smsService = smsService;
    }

    @GetMapping(value = "/test")
    public void set() throws Exception {
        //redisTemplate.opsForValue().set("key", "value2");
        SendSmsRequest smsRequest = new SendSmsRequest();
        smsRequest.setSignName("合生活");
        smsRequest.setTemplateCode("SMS_230960350");
        smsRequest.setPhoneNumbers("18937671061");
        smsService.sendSms(smsRequest);
    }
}
