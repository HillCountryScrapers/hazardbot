package com.corelogic.hazardbot;

import com.corelogic.hazardbot.subscriber.Subscriber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class WelcomeController {
    @GetMapping
    public String welcome(Model model) {
        model.addAttribute("subscriber", new Subscriber());
        return "welcome";
    }
}
