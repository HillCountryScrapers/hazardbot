package com.corelogic.hazardbot.notification.smsclient;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SmsCredentials {
    private Map<String, String> env;

    public SmsCredentials() {
        env = System.getenv();
    }

    public String getAccountSid() {
        return env.get("TWILIO_ACCOUNT_SID");
    }

    public String getAuthToken() {
        return env.get("TWILIO_AUTH_TOKEN");
    }

    public String getPhoneNumber() {
        return env.get("TWILIO_PHONE_NUMBER");
    }
}

