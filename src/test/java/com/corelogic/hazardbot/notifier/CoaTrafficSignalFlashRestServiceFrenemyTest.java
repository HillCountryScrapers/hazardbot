package com.corelogic.hazardbot.notifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoaTrafficSignalFlashRestServiceFrenemyTest {
    @Test
    public void getFlashingSignals() throws Exception {
        CoaTrafficSignalFlashRestService subject = new CoaTrafficSignalFlashRestService();

        final List<FlashingSignal> allFlashingSignals = subject.getAllFlashingSignals();
        assertThat(allFlashingSignals.size(), greaterThan(0));
    }
}