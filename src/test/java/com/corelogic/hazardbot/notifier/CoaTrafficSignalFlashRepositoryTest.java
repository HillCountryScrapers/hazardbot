package com.corelogic.hazardbot.notifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoaTrafficSignalFlashRepositoryTest {
    @Mock
    CoaTrafficSignalFlashRestService mockCoaTrafficSignalFlashRestService;

    @Test
    public void getNewTrafficSignalFlash_returnsFlashingSignalsNotAlreadyInList() throws Exception {
        List<FlashingSignal> oldFlashingSignals = Arrays.asList(
            new FlashingSignal("signal1")
        );

        List<FlashingSignal> newFlashingSignals = Arrays.asList(
                new FlashingSignal("signal1"),
                new FlashingSignal("signal2")
        );

        List<FlashingSignal> expected = Arrays.asList(
                new FlashingSignal("signal2")
        );

        when(mockCoaTrafficSignalFlashRestService.getAllFlashingSignals())
                .thenReturn(oldFlashingSignals)
                .thenReturn(newFlashingSignals);

        CoaTrafficSignalFlashRepository subject = new CoaTrafficSignalFlashRepository(mockCoaTrafficSignalFlashRestService);
        assertThat(subject.getNewTrafficSignalFlash(), equalTo(expected));
    }
}