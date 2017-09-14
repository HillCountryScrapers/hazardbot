package com.corelogic.hazardbot.persistence;

import com.corelogic.hazardbot.subscriber.Subscriber;

import java.util.List;

public interface SubscriberLookupService {
    List<Subscriber> getSubscribers(String postalCode);
}
