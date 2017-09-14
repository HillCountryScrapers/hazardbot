package com.corelogic.hazardbot.subscriber;

public class Subscriber {
    private String phoneNumber;
    private Long id;

    public Subscriber() {
    }

    public Subscriber(String phoneNumber, Long id) {
        this.phoneNumber = phoneNumber;
        this.id = id;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
