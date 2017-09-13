package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.smsclient.SmsRestClient;
import com.corelogic.hazardbot.persistence.SubscriberLookupService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class SmsNotificationServiceTest {
    @Test
    public void notifySubscribers() throws Exception {
        SmsRestClient mocksmsRestClient = mock(SmsRestClient.class);
        SubscriberLookupService mockSubscriberLookupService;
        mockSubscriberLookupService = mock(SubscriberLookupService.class);
        final List<Long> numbers = Arrays.asList(
                123456789l,
                234567894l,
                789456123l
        );
        SmsNotificationService subject = new SmsNotificationService(
                mocksmsRestClient,
                mockSubscriberLookupService
        );
        when(mockSubscriberLookupService.getSubscribers()).thenReturn(numbers);

        Event event = new Event("Something happened!");
        subject.notifySubscribers(event);
        verify(mockSubscriberLookupService).getSubscribers();
        verify(mocksmsRestClient).sendSms(numbers, event.getContent());
    }
}