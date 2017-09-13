package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.HazardbotApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.fail;


@RunWith(SpringRunner.class)
@ActiveProfiles("mock")
@SpringBootTest(classes = HazardbotApplication.class)
public class SmsNotificationServiceIntegrationTest {
    @Autowired
    SmsNotificationService subject;

    @Test
    public void notifySubscribers() throws SmsNotificationException {
        Event event = new Event("Notify this!");
        try {
            subject.notifySubscribers(event);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }
}