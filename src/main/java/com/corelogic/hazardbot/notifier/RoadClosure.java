package com.corelogic.hazardbot.notifier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RoadClosure {

    private String location;
    private String crossStreets;
}
