package com.corelogic.hazardbot.notification.smsclient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SmsRestClientFrenemyTest {

    //Commenting out test because it will send a sms message to a real phone number on every build
    //@Test
    public void sendSms() throws Exception {
        SmsCredentials smsCredentials = new SmsCredentials();
        System.out.print("Twilio Number: "+smsCredentials.getPhoneNumber());
        SmsRestClientImpl subject = new SmsRestClientImpl(smsCredentials);
        List<Long> phoneNumbers = Arrays.asList(6196258494l, 2814511243l);
        String content = "Something happened!";

        Map<Long, String> expected = new HashMap<>();
        expected.put(6196258494l, "queued");
        expected.put(2814511243l, "queued");

        Map<Long, String> results = subject.sendSms(phoneNumbers, content);
        assertThat(results.size(), equalTo(phoneNumbers.size()));
        assertThat(results,equalTo(expected));

    }
}