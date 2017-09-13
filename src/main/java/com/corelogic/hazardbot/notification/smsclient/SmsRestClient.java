package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.notification.SmsNotificationException;

import java.util.List;
import java.util.Map;

public interface SmsRestClient {
    public Map<Long, String> sendSms(List<Long> numbers, String content) throws SmsNotificationException;
}
