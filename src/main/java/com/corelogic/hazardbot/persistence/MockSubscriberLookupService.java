package com.corelogic.hazardbot.persistence;

import com.corelogic.hazardbot.subscriber.Subscriber;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Profile("mock")
public class MockSubscriberLookupService implements SubscriberLookupService {
    @Override
    public List<Subscriber> getSubscribers() {
        return Arrays.asList(
            new Subscriber("123456789", 0L, "78739"),
            new Subscriber("234567894", 1L, "78759"),
            new Subscriber("789456123", 2L, null)
        );
    }
}
