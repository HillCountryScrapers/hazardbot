package com.corelogic.hazardbot.persistence;

import com.corelogic.hazardbot.subscriber.Subscriber;
import com.corelogic.hazardbot.subscriber.SubscriberEntity;
import com.corelogic.hazardbot.subscriber.SubscriberRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SubscriberLookupServiceImplTest {
    @Mock
    private SubscriberRepository mockSubscriberRepository;

    private SubscriberLookupServiceImpl subject;

    @Before
    public void setUp() throws Exception {
        subject = new SubscriberLookupServiceImpl(mockSubscriberRepository);

    }

    @Test
    public void getSubscribers() throws Exception {
        when(mockSubscriberRepository.findAll()).thenReturn(
            Arrays.asList(
                new SubscriberEntity("123", "78758"),
                new SubscriberEntity("456", "78758"),
                new SubscriberEntity("789", "78739"),
                new SubscriberEntity("789", null),
                new SubscriberEntity("789", "")
            )
        );
        final List<Subscriber> subscribers = subject.getSubscribers("78758");

        verify(mockSubscriberRepository).findAll();
        BDDAssertions.then(subscribers).hasSize(4);
    }

    @Test
    public void getSubscribers_whenOutageZipCodeIsNull() throws Exception {
        when(mockSubscriberRepository.findAll()).thenReturn(
            Arrays.asList(
                new SubscriberEntity("123", "78758"),
                new SubscriberEntity("456", "78758"),
                new SubscriberEntity("789", "78739"),
                new SubscriberEntity("789", null)
            )
        );

        final List<Subscriber> subscribers = subject.getSubscribers(null);

        BDDAssertions.then(subscribers).hasSize(4);
    }

    @Test
    public void getSubscribers_whenOutageZipCodeIsEmptyString() throws Exception {
        when(mockSubscriberRepository.findAll()).thenReturn(
            Arrays.asList(
                new SubscriberEntity("123", "78758"),
                new SubscriberEntity("456", "78758"),
                new SubscriberEntity("789", "78739"),
                new SubscriberEntity("789", null)
            )
        );

        final List<Subscriber> subscribers = subject.getSubscribers("");

        BDDAssertions.then(subscribers).hasSize(4);
    }
}
