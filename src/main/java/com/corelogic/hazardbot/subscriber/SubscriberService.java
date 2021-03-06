package com.corelogic.hazardbot.subscriber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriberService {

    private final PhoneNumberFormatter phoneNumberFormatter;
    private SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository,
                             PhoneNumberFormatter phoneNumberFormatter) {
        this.subscriberRepository = subscriberRepository;
        this.phoneNumberFormatter = phoneNumberFormatter;
    }

    public void create(Subscriber subscriber) {
        subscriberRepository.saveAndFlush(
            new SubscriberEntity(
                phoneNumberFormatter.strip(subscriber.getPhoneNumber()),
                subscriber.getPostalCode()
            )
        );
    }

    public List<Subscriber> getSubscribers() {
        return subscriberRepository.findAll().stream()
            .map(this::transformEntity)
            .collect(Collectors.toList());
    }

    public void remove(long subscriberId) {
        subscriberRepository.delete(subscriberId);
    }

    public Subscriber getSubscriber(String phoneNumber) {
        final String strippedPhoneNumber = phoneNumberFormatter.strip(phoneNumber);

        final SubscriberEntity subscriberEntity =
            subscriberRepository.findByPhoneNumber(strippedPhoneNumber);

        return transformEntity(subscriberEntity);
    }

    private Subscriber transformEntity(SubscriberEntity subscriberEntity) {
        return subscriberEntity == null ? null : new Subscriber(
            phoneNumberFormatter.format(subscriberEntity.getPhoneNumber()),
            subscriberEntity.getId(),
            subscriberEntity.getPostalCode()
        );
    }

    public Subscriber getSubscriber(Long subscriberId) {
        final SubscriberEntity subscriberEntity = subscriberRepository.getOne(subscriberId);
        return transformEntity(subscriberEntity);
    }


}
