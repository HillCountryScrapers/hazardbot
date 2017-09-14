package com.corelogic.hazardbot.smsTest;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.NotificationService;
import com.corelogic.hazardbot.subscriber.Subscriber;
import com.corelogic.hazardbot.subscriber.SubscriberEntity;
import com.corelogic.hazardbot.subscriber.SubscriberRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/smsTest")
@Slf4j
public class SmsTestController {

    private final SubscriberRepository subscriberRepository;
    private final NotificationService notificationService;

    @Autowired
    public SmsTestController(SubscriberRepository subscriberRepository,
                             NotificationService notificationService) {
        this.subscriberRepository = subscriberRepository;
        this.notificationService = notificationService;
    }

    @PostMapping
    @SneakyThrows
    public String testSms(@RequestParam Long subscriberId,
                          Model model) {
        final Subscriber subscriber = getSubscriber(subscriberId);

        final Event event = new Event("Hello, this is CoreLogic HazardBot 🤖");
        notificationService.notifySubscribers(event);

        model.addAttribute("subscriber", subscriber);

        return "testSms";
    }

    private Subscriber getSubscriber(Long subscriberId) {
        final SubscriberEntity subscriberEntity = subscriberRepository.getOne(subscriberId);
        return new Subscriber(
            subscriberEntity.getPhoneNumber(),
            subscriberEntity.getId(),
            subscriberEntity.getPostalCode()
        );
    }
}
