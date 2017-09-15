package com.corelogic.hazardbot.smsTest;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.NotificationService;
import com.corelogic.hazardbot.subscriber.Subscriber;
import com.corelogic.hazardbot.subscriber.SubscriberEntity;
import com.corelogic.hazardbot.subscriber.SubscriberRepository;
import com.corelogic.hazardbot.subscriber.SubscriberService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Collections;

@Controller
@RequestMapping("/smsTest")
@Slf4j
public class SmsTestController {

    private final NotificationService notificationService;
    private final SubscriberService subscriberService;

    @Autowired
    public SmsTestController(SubscriberService subscriberService,
                             NotificationService notificationService) {
        this.subscriberService = subscriberService;
        this.notificationService = notificationService;
    }

    @PostMapping
    @SneakyThrows
    public String testSms(@RequestParam Long subscriberId,
                          Model model) {
        final Subscriber subscriber = subscriberService.getSubscriber(subscriberId);

        final Event event = new Event("Hello, this is CoreLogic HazardBot 🤖");
        notificationService.notifySubscribers(event, Collections.singletonList(subscriber));

        model.addAttribute("subscriber", subscriber);

        return "testSms";
    }

}
