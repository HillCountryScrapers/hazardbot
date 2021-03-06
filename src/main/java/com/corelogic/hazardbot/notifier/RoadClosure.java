package com.corelogic.hazardbot.notifier;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.smsclient.EventType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class RoadClosure implements Outage {

    @JsonProperty("sr_location")
    private String location;
    @JsonProperty("cross_streets")
    private String crossStreets;
    @JsonProperty("zip_code")
    private String postalCode;

    @Override
    public Event getEvent() {
        return new Event(
            String.format("Road Closure: %s at %s", location, crossStreets),
            EventType.ROAD_CLOSURE
        );
    }
}
