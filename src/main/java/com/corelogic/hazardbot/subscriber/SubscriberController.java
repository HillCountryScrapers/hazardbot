package com.corelogic.hazardbot.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("{id}")
    public ModelAndView removeSubscriber(@PathVariable Long id) {
        logger.info("Removing subscriber id={}", id);
        subscriberService.remove(id);
        return new ModelAndView("redirect:/subscribers");
    }

}
