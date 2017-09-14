package com.corelogic.hazardbot.subscriber;

import com.corelogic.hazardbot.HazardbotApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HazardbotApplication.class)
@Transactional
public class SubscriberServiceTest {

    @Autowired
    SubscriberService subject;
    @Autowired
    SubscriberRepository subscriberRepository;

    @Test
    public void create() throws Exception {
        int size = subscriberRepository.findAll().size();
        final Subscriber subscriber = new Subscriber("123", 1L, "78758");
        subject.create(subscriber);

        then(subscriberRepository.findAll()).hasSize(size + 1);
    }

    @Test
    public void getSubscribers() throws Exception {
        subscriberRepository.deleteAll();
        subscriberRepository.save(new SubscriberEntity("123", "78758"));

        then(subject.getSubscribers()).hasSize(1);
        then(subject.getSubscribers().get(0).getPhoneNumber())
            .isEqualTo("123");
    }

    @Test
    public void getSubscriber() throws Exception {
        subscriberRepository.deleteAll();
        subscriberRepository.save(new SubscriberEntity("123", "78758"));

        then(subject.getSubscriber("123").getPhoneNumber()).isEqualTo("123");
    }

    @Test
    public void getSubscriber_whenNotFound_returnsNull() throws Exception {
        subscriberRepository.deleteAll();
        subscriberRepository.save(new SubscriberEntity("123", "78758"));

        then(subject.getSubscriber("456")).isNull();
    }

    @Test
    public void remove() throws Exception {
        subscriberRepository.deleteAll();
        final SubscriberEntity subscriberEntity =
            subscriberRepository.save(new SubscriberEntity("123", "78758"));

        subject.remove(subscriberEntity.getId());

        then(subscriberRepository.findAll()).hasSize(0);
    }
}
