package com.corelogic.hazardbot.notification;

import com.corelogic.hazardbot.Event;

public interface NotificationService {
    void notifySubscribers(Event event);
}
