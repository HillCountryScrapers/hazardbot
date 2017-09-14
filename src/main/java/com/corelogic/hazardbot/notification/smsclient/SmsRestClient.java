package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.subscriber.Subscriber;

import java.util.List;

public interface SmsRestClient {
    void sendSms(List<Subscriber> numbers, String content);
}
