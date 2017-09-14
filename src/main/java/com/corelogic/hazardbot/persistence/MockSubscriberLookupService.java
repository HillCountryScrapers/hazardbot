package com.corelogic.hazardbot.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Profile("mock")
public class MockSubscriberLookupService implements SubscriberLookupService {
    @Override
    public List<String> getSubscribers() {
        return Arrays.asList(
                "123456789",
                "234567894",
                "789456123"
        );
    }
}
