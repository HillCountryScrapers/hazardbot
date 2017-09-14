package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.subscriber.Subscriber;

import java.util.List;

public interface NotificationService {
    void notifySubscribers(Event event, List<Subscriber> subscribers);
}
