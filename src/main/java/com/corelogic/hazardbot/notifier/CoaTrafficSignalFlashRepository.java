package com.corelogic.hazardbot.notifier;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class CoaTrafficSignalFlashRepository {
    private final CoaTrafficSignalFlashRestService coaTrafficSignalFlashRestService;
    private List<FlashingSignal> existingFlashingSignals;

    public CoaTrafficSignalFlashRepository(CoaTrafficSignalFlashRestService coaTrafficSignalFlashRestService) {
        this.coaTrafficSignalFlashRestService = coaTrafficSignalFlashRestService;
        existingFlashingSignals = coaTrafficSignalFlashRestService.getAllFlashingSignals();
    }

    public List<FlashingSignal> getNewTrafficSignalFlash() {
        final List<FlashingSignal> newFlashingSignals = coaTrafficSignalFlashRestService.getAllFlashingSignals();

        final Sets.SetView<FlashingSignal> difference = Sets.difference(
                new HashSet<>(newFlashingSignals),
                new HashSet<>(existingFlashingSignals)
        );

        existingFlashingSignals = newFlashingSignals;

        return new ArrayList<>(difference);
    }
}
