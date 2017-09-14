package com.corelogic.hazardbot.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberService {

    private SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public void create(Subscriber subscriber) {
        subscriberRepository.saveAndFlush(
            new SubscriberEntity(subscriber.getPhoneNumber())
        );
    }

    public List<Subscriber> getSubscribers() {
        return subscriberRepository.findAll().stream()
            .map(
                subscriberEntity -> new Subscriber(subscriberEntity.getPhoneNumber(), subscriberEntity.getId())
            )
            .collect(Collectors.toList());
    }

    public void remove(long subscriberId) {
        subscriberRepository.delete(subscriberId);
    }
}
