package com.corelogic.hazardbot.notification.smsclient;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Profile("mock")
@Component
public class MockSmsRestClient implements SmsRestClient {
    @Override
    public Map<Long, String> sendSms(List<Long> numbers, String content) {
        return null;
    }
}
