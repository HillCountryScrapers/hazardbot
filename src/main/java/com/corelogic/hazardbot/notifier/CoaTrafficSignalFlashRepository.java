package com.corelogic.hazardbot.notifier;

import com.google.common.collect.Sets;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
public class CoaTrafficSignalFlashRepository {
    private final CoaTrafficSignalFlashRestService coaTrafficSignalFlashRestService;
    private final List<FlashingSignal> oldFlashingSignals;

    public CoaTrafficSignalFlashRepository(CoaTrafficSignalFlashRestService coaTrafficSignalFlashRestService) {
        this.coaTrafficSignalFlashRestService = coaTrafficSignalFlashRestService;
        oldFlashingSignals = coaTrafficSignalFlashRestService.getAllFlashingSignals();
    }

    public List<FlashingSignal> getNewTrafficSignalFlash() {
        final List<FlashingSignal> newFlashingSignals = coaTrafficSignalFlashRestService.getAllFlashingSignals();

        final Sets.SetView<FlashingSignal> difference = Sets.difference(
                new HashSet<>(newFlashingSignals),
                new HashSet<>(oldFlashingSignals)
        );

        return new ArrayList<>(difference);
    }
}
