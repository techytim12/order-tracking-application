package com.snaply.order_tracking.service.impl;

import com.snaply.order_tracking.service.WhatsAppService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppServiceImpl implements WhatsAppService {

    @Value("${from.whatsapp.number}")
    private String fromWhatsappNumber;

    public WhatsAppServiceImpl(
            @Value("${account.sid}") String accountSid,
            @Value("${auth.token}") String authToken
    ){
        Twilio.init(accountSid, authToken);
    }

    @Override
    public void sendWhatsAppMessage(String toPhoneNumber, String message) {

        Message.creator(
                new com.twilio.type.PhoneNumber("whatsapp:" + toPhoneNumber),
                new com.twilio.type.PhoneNumber(fromWhatsappNumber),
                message
        ).create();
    }
}
