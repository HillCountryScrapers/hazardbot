package com.corelogic.hazardbot.subscriber;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
public class SubscriberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    @Length(min = 10)
    @Pattern(regexp = "[0-9]{10}")
    private String phoneNumber;

    private String postalCode;

    public SubscriberEntity(String phoneNumber, String postalCode) {
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
    }
}
