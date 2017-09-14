package com.corelogic.hazardbot.notification.smsclient;

import com.twilio.rest.api.v2010.account.MessageCreator;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MessageCreatorProviderTest {
    @Mock
    private SmsCredentials mockSmsCredentials;

    @Test
    public void get() throws Exception {
        when(mockSmsCredentials.getPhoneNumber()).thenReturn("456");

        MessageCreatorProvider subject = new MessageCreatorProvider(mockSmsCredentials);


        final MessageCreator messageCreator = subject.get("123", "content");

        verify(mockSmsCredentials).getPhoneNumber();

        BDDAssertions.then(messageCreator).isNotNull();
    }
}