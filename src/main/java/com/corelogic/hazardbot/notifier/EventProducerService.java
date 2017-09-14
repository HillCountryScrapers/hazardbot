package com.corelogic.hazardbot.notifier;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notification.NotificationService;
import com.corelogic.hazardbot.persistence.SubscriberLookupService;
import com.corelogic.hazardbot.subscriber.Subscriber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EventProducerService {

    private final StubRoadClosureRepository stubRoadClosureRepository;
    private final CoaRoadClosureRepository coaRoadClosureRepository;
    private final CoaTrafficSignalFlashRepository coaTrafficSignalFlashRepository;
    private final NotificationService notificationService;
    private final SubscriberLookupService subscriberLookupService;

    public EventProducerService(StubRoadClosureRepository stubRoadClosureRepository,
                                CoaRoadClosureRepository coaRoadClosureRepository,
                                CoaTrafficSignalFlashRepository coaTrafficSignalFlashRepository,
                                NotificationService notificationService,
                                SubscriberLookupService subscriberLookupService) {
        this.stubRoadClosureRepository = stubRoadClosureRepository;
        this.coaRoadClosureRepository = coaRoadClosureRepository;
        this.coaTrafficSignalFlashRepository = coaTrafficSignalFlashRepository;
        this.notificationService = notificationService;
        this.subscriberLookupService = subscriberLookupService;
    }

    @Scheduled(fixedRate = 30000)
    public void checkForEvents() {
        log.info("Firing checkForEvents");
        final List<RoadClosure> roadClosures = stubRoadClosureRepository.getNewRoadClosureEvents();
        handleOutage(roadClosures);
        final List<RoadClosure> coaRoadClosures = coaRoadClosureRepository.getNewRoadClosureEvents();
        handleOutage(coaRoadClosures);
        final List<FlashingSignal> coaTrafficSignalFlash = coaTrafficSignalFlashRepository.getNewTrafficSignalFlash();
        handleOutage(coaTrafficSignalFlash);
    }

    private void handleOutage(List<? extends Outage> outages) {
        outages.stream().forEach((outage) -> {
            Event eventToNotify = outage.getEvent();
            log.info("Event to notify {}", eventToNotify.getContent());

            final List<Subscriber> subscribers = subscriberLookupService.getSubscribers();

            notificationService.notifySubscribers(eventToNotify, subscribers);
        });
    }
}
