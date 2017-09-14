package com.corelogic.hazardbot.notification.smsclient;

import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Profile("!mock")
@Component
@Slf4j
public class SmsRestClientImpl implements SmsRestClient {
    private final TwilioRestClient twilioRestClient;
    private final MessageCreatorProvider messageCreatorProvider;

    public SmsRestClientImpl(TwilioRestClient twilioRestClient,
                             MessageCreatorProvider messageCreatorProvider) {
        this.twilioRestClient = twilioRestClient;
        this.messageCreatorProvider = messageCreatorProvider;
    }

    @Override
    public void sendSms(List<String> numbers, String content) {
        for (String number : numbers) {
            try {
                final Message message = messageCreatorProvider.get(number, content).create(this.twilioRestClient);
                log.info("message created for number {}, status: {}", number, message.getStatus().toString());
            } catch (Exception e) {
                String errorMsg = String.format("An exception occurred trying to send a message to %s, exception: %s",
                        number, e.getMessage());
                log.error(errorMsg);
            }
        }
    }
}