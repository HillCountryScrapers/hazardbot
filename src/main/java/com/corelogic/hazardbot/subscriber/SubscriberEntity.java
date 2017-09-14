package com.corelogic.hazardbot.subscriber;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
public class SubscriberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String phoneNumber;

    private String postalCode;

    public SubscriberEntity(String phoneNumber, String postalCode) {
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
    }
}
