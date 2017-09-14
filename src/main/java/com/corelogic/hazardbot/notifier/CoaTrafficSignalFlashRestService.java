package com.corelogic.hazardbot.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class CoaTrafficSignalFlashRestService {

    public List<FlashingSignal> getAllFlashingSignals() {
        final RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<FlashingSignal>> coaResponse =
                restTemplate.exchange("https://data.austintexas.gov/resource/utgi-umz5.json",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<FlashingSignal>>() {
                        });

        List<FlashingSignal> coaFlashingSignals = coaResponse.getBody();

        log.info("Flashing traffic signals = {}", coaFlashingSignals.size());
        return coaFlashingSignals;
    }

}
