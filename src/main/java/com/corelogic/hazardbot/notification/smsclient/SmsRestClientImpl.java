package com.corelogic.hazardbot.notification.smsclient;

import com.twilio.exception.TwilioException;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Profile("!mock")
@Component
@Slf4j
public class SmsRestClientImpl implements SmsRestClient {
    private final TwilioRestClient twilioRestClient;
    private final String twilioNumber;

    public SmsRestClientImpl(SmsCredentials smsCredentials) {
        this.twilioRestClient =
                new TwilioRestClient.Builder(
                        smsCredentials.getAccountSid(),
                        smsCredentials.getAuthToken()
                ).build();
        this.twilioNumber = smsCredentials.getPhoneNumber();
    }

    @Override
    public Map<Long, String> sendSms(List<Long> numbers, String content) {
        Map<Long, String> messages = new HashMap<>();
        for (Long number : numbers) {
            MessageCreator messageCreator = new MessageCreator(
                    new PhoneNumber(number.toString()),
                    new PhoneNumber(this.twilioNumber),
                    content);
            // messageCreator.setMediaUrl(mediaUrl);
            try {
                messages.put(number,
                        messageCreator.create(this.twilioRestClient).getStatus().toString());
            } catch (TwilioException e) {
                log.error(
                        "An exception occurred trying to send a message to {}, exception: {}",
                        number.toString(),
                        e.getMessage());
            }
        }
        return messages;
    }
}