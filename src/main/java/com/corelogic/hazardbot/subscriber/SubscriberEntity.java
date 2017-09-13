package com.corelogic.hazardbot.subscriber;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubscriberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public SubscriberEntity() {
    }

    public Long getId() {
        return id;
    }

    public SubscriberEntity(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
