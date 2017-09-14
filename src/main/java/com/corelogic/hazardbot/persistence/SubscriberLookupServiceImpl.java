package com.corelogic.hazardbot.persistence;

import com.corelogic.hazardbot.subscriber.SubscriberEntity;
import com.corelogic.hazardbot.subscriber.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Profile("!mock")
@Service
public class SubscriberLookupServiceImpl implements SubscriberLookupService {
    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberLookupServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public List<String> getSubscribers() {
        return subscriberRepository.findAll().stream()
                .map(SubscriberEntity::getPhoneNumber)
                .collect(Collectors.toList());
    }
}
