package com.corelogic.hazardbot.notification.smsclient;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Data
@Component
@ConfigurationProperties("twilio")
@Validated
public class SmsCredentials {
    @NotNull
    private String accountSid;
    @NotNull
    private String authToken;
    @NotNull
    private String phoneNumber;
}

