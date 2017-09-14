package com.corelogic.hazardbot.subscriber;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class SubscriberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String phoneNumber;

    private String postalCode;

    public SubscriberEntity(String phoneNumber, String postalCode) {
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
    }
}
