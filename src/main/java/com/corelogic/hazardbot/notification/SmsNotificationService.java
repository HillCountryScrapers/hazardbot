package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.smsclient.SmsRestClient;
import com.corelogic.hazardbot.subscriber.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmsNotificationService implements NotificationService {
    private final SmsRestClient smsRestClient;

    @Autowired
    public SmsNotificationService(SmsRestClient smsRestClient) {
        this.smsRestClient = smsRestClient;
    }

    @Override
    public void notifySubscribers(Event event, List<Subscriber> subscribers) {
        this.smsRestClient.sendSms(
            subscribers,
            event.getContent()
        );
    }
}
