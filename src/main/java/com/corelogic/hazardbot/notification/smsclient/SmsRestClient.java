package com.corelogic.hazardbot.notification.smsclient;

import java.util.List;

public interface SmsRestClient {
    void sendSms(List<String> numbers, String content);
}
