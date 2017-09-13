package com.corelogic.hazardbot.subscriber;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, Long> {
    List<SubscriberEntity> findAllByPhoneNumber(String phoneNumber);
}
