package com.corelogic.hazardbot.subscriber;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscriber {
    private String phoneNumber;
    private Long id;
    private String postalCode;
}
