package com.corelogic.hazardbot.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/subscribers")
public class SubscriberController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberController.class);
    private SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public String listSubscribers(Model model) {
        model.addAttribute("subscribers", subscriberService.getSubscribers());
        return "subscribers";
    }

    @PostMapping
    public ModelAndView createSubscriber(@ModelAttribute Subscriber subscriber) {
        logger.info("Creating subscriber {}", subscriber.getPhoneNumber());
        subscriberService.create(subscriber);
        return new ModelAndView("redirect:/subscribers");
    }

}
