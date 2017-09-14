package com.corelogic.hazardbot.notifier;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class FlashingSignal {
    @JsonProperty("location_name")
    private String locationName;
}
