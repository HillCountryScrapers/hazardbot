package com.corelogic.hazardbot.notification.smsclient;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("mock")
@Component
public class MockSmsRestClient implements SmsRestClient {

    @Override
    public void sendSms(List<String> numbers, String content) {
    }
}
