package com.corelogic.hazardbot.notification.smsclient;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class SmsContent {
    private String content;
    private EventType eventType;

    public SmsContent(String content) {
        this.content = content;
        this.eventType = EventType.CLOWN;
    }
}
