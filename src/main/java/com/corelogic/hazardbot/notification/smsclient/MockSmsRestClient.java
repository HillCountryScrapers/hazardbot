package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.subscriber.Subscriber;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mock")
@Component
public class MockSmsRestClient implements SmsRestClient {

    @Override
    public void sendSms(List<Subscriber> subscribers, SmsContent smsContent) {
    }
}
