package com.corelogic.hazardbot.subscriber;

import com.corelogic.hazardbot.HazardbotApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

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
        subscriberRepository.deleteAll();
        final Subscriber subscriber = new Subscriber("512-555-1212", 1L, "78758");
        subject.create(subscriber);
        final List<SubscriberEntity> entities = subscriberRepository.findAll();
        then(entities).hasSize(1);
        then(entities.get(0).getPhoneNumber()).isEqualTo("5125551212");
    }

    @Test
    public void getSubscribers() throws Exception {
        subscriberRepository.deleteAll();
        subscriberRepository.save(new SubscriberEntity("5125551212", "78758"));

        then(subject.getSubscribers()).hasSize(1);
        then(subject.getSubscribers().get(0).getPhoneNumber())
            .isEqualTo("512-555-1212");
    }

    @Test
    public void getSubscriber() throws Exception {
        subscriberRepository.deleteAll();
        subscriberRepository.save(new SubscriberEntity("5125551212", "78758"));

        then(subject.getSubscriber("5125551212").getPhoneNumber()).isEqualTo("512-555-1212");
    }

    @Test
    public void getSubscriber_whenNotFound_returnsNull() throws Exception {
        subscriberRepository.deleteAll();
        subscriberRepository.save(new SubscriberEntity("5125551212", "78758"));

        then(subject.getSubscriber("5125551213")).isNull();
    }

    @Test
    public void remove() throws Exception {
        subscriberRepository.deleteAll();
        final SubscriberEntity subscriberEntity =
            subscriberRepository.save(new SubscriberEntity("5125551212", "78758"));

        subject.remove(subscriberEntity.getId());

        then(subscriberRepository.findAll()).hasSize(0);
    }
}
