package com.corelogic.hazardbot.notification.smsclient;

import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageCreatorProvider {

    private final SmsCredentials smsCredentials;

    @Autowired
    public MessageCreatorProvider(SmsCredentials smsCredentials) {
        this.smsCredentials = smsCredentials;
    }

    public MessageCreator get(String number, String content) {
        return new MessageCreator(
                new PhoneNumber(number),
                new PhoneNumber(smsCredentials.getPhoneNumber()),
                content
        );
    }
}
