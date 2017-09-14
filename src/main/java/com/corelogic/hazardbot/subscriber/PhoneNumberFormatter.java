package com.corelogic.hazardbot.subscriber;

import org.springframework.stereotype.Component;

@Component
public class PhoneNumberFormatter {
    public String format(String input) {
        return input.substring(0, 3) + "-" + input.substring(3, 6) + "-" + input.substring(6, 10);
    }

    public String strip(String phoneNumber) {
        return phoneNumber.replaceAll("\\D", "");
    }
}
