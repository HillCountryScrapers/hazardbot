package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.notification.SmsNotificationException;

import java.util.List;
import java.util.Map;

public interface SmsRestClient {
    Map<String, String> sendSms(List<String> numbers, String content) throws SmsNotificationException;
}
