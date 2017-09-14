package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.subscriber.Subscriber;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.account.MessageCreator;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SmsRestClientImplTest {
    @Mock
    private TwilioRestClient mockTwilioRestClient;

    @Mock
    private MessageCreatorProvider mockMessageCreatorProvider;

    @Test
    public void sendSms() throws Exception {
        SmsRestClientImpl subject = new SmsRestClientImpl(mockTwilioRestClient, mockMessageCreatorProvider);

        final MessageCreator mockMessageCreator = mock(MessageCreator.class);
        when(mockMessageCreatorProvider.get(any(), any())).thenReturn(
            mockMessageCreator
        );

        subject.sendSms(
            Arrays.asList(
                new Subscriber("123", null, null)
            ),
            new SmsContent("content")
        );

        verify(mockMessageCreatorProvider).get("123", "🤡content");
        verify(mockMessageCreator).create(mockTwilioRestClient);
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void sendSms_whenMessageCreatorThrowsAnException_catchIt() throws Exception {
        SmsRestClientImpl subject = new SmsRestClientImpl(mockTwilioRestClient, mockMessageCreatorProvider);

        final MessageCreator mockMessageCreator = mock(MessageCreator.class);
        when(mockMessageCreatorProvider.get(any(), any())).thenReturn(
            mockMessageCreator
        );

        when(mockMessageCreator.create(any())).thenThrow(new RuntimeException());

        subject.sendSms(
            Arrays.asList(
                new Subscriber("123", null, null)
            ),
            new SmsContent("content")
        );
    }

    @Test
    public void name() throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(Character.toChars(127467));
        sb.append(Character.toChars(127479));
        System.out.println(sb);
    }
}
