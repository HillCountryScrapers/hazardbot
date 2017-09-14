package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.smsclient.SmsContent;
import com.corelogic.hazardbot.notification.smsclient.SmsRestClientImpl;
import com.corelogic.hazardbot.subscriber.Subscriber;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SmsNotificationServiceTest {
    @Test
    public void notifySubscribers() throws Exception {
        SmsRestClientImpl mocksmsRestClientImpl = mock(SmsRestClientImpl.class);
        final List<Subscriber> subscribers = Arrays.asList(
            new Subscriber("123456789", null, null),
            new Subscriber("234567894", null, null),
            new Subscriber("789456123", null, null)
        );
        SmsNotificationService subject = new SmsNotificationService(mocksmsRestClientImpl);

        Event event = new Event("Something happened!");
        SmsContent smsContent = new SmsContent("Something happened!");
        subject.notifySubscribers(event, subscribers);
        verify(mocksmsRestClientImpl).sendSms(subscribers, smsContent);
    }
}
