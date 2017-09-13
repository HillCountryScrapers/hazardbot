package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.smsclient.SmsRestClient;
import com.corelogic.hazardbot.persistence.SubscriberLookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {
    private final SmsRestClient smsRestClient;
    private final SubscriberLookupService subscriberLookupService;

    @Autowired
    public SmsNotificationService(
            SmsRestClient smsRestClient,
            SubscriberLookupService subscriberLookupService) {
        this.smsRestClient = smsRestClient;
        this.subscriberLookupService = subscriberLookupService;
    }

    @Override
    public void notifySubscribers(Event event) throws SmsNotificationException{
        this.smsRestClient.sendSms(
                this.subscriberLookupService.getSubscribers(),
                event.getContent()
        );
    }
}
