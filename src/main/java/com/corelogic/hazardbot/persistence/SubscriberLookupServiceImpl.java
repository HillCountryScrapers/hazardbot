package com.corelogic.hazardbot.persistence;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("!mock")
@Service
public class SubscriberLookupServiceImpl implements SubscriberLookupService {
    public List<Long> getSubscribers() {
        return null;
    }
}
