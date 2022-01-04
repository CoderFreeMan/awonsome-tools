package com.awonsome.common.sms.service;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import org.springframework.stereotype.Service;

/**
 * @author yangdejun
 * @TODO
 * @date 2022/1/3 22:27
 */
@Service
public class SmsService {

    private final Client smsClient;

    public SmsService(Client smsClient) {
        this.smsClient = smsClient;
    }

    public SendSmsResponse sendSms(SendSmsRequest smsRequest) throws Exception {
        return smsClient.sendSms(smsRequest);
    }
}
