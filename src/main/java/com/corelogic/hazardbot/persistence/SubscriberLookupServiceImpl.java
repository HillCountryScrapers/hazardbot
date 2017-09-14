package com.corelogic.hazardbot.persistence;

import com.corelogic.hazardbot.subscriber.Subscriber;
import com.corelogic.hazardbot.subscriber.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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

    public List<Subscriber> getSubscribers(String postalCode) {
        return subscriberRepository.findAll().stream()
            .filter((subscriberEntity) -> StringUtils.isEmpty(postalCode) || StringUtils.isEmpty(subscriberEntity.getPostalCode()) || subscriberEntity.getPostalCode().equals(postalCode))
            .map((subscriber) -> new Subscriber(subscriber.getPhoneNumber(),
                subscriber.getId(),
                subscriber.getPostalCode()))
            .collect(Collectors.toList());
    }
}
