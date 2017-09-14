package com.corelogic.hazardbot.notifier;

import com.corelogic.hazardbot.Event;

public interface Outage {
    Event getEvent();
    String getPostalCode();
}
