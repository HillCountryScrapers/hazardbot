package com.corelogic.hazardbot.notification.smsclient;

import com.twilio.http.TwilioRestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmsConfiguration {
    @Bean
    public TwilioRestClient twilioRestClient(SmsCredentials smsCredentials) {
        return new TwilioRestClient.Builder(
                        smsCredentials.getAccountSid(),
                        smsCredentials.getAuthToken()
                ).build();
    }
}
