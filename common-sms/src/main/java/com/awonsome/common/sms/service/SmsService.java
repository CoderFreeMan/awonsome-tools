package com.awonsome.common.sms.service;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponse;
import org.springframework.stereotype.Service;

/**
 * 短信服务
 * @author yangdejun
 * @date 2022/1/3 22:27
 */
@Service
public class SmsService {

    private final Client smsClient;

    public SmsService(Client smsClient) {
        this.smsClient = smsClient;
    }

    /**
     * 发送短信
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

}
