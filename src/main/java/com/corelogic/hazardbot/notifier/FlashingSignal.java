package com.corelogic.hazardbot.notifier;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.smsclient.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlashingSignal implements Outage {
    @JsonProperty("location_name")
    private String locationName;

    @Override
    public Event getEvent() {
        return new Event(
            String.format("Traffic signal outage at %s", locationName),
            EventType.TRAFFIC_LIGHT
        );
    }

    @Override
    public String getPostalCode() {
        return "78758";
    }
}
