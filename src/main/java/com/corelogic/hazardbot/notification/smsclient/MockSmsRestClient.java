package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.notification.SmsNotificationException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Profile("mock")
@Component
public class MockSmsRestClient implements SmsRestClient {

    @Override
    public Map<String, String> sendSms(List<String> numbers, String content) throws SmsNotificationException {
        Map<String, String> results = new HashMap<>();
        results.put("6196258494", "queued");
        results.put("2814511243", "queued");
        return results;
    }
}
