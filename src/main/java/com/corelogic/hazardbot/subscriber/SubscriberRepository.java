package com.corelogic.hazardbot.subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {
    Long countByPhoneNumber(String phoneNumber);
}
