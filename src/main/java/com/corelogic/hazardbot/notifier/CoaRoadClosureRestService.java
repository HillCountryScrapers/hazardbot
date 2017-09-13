package com.corelogic.hazardbot.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Profile("!mock")
@Slf4j
public class CoaRoadClosureRestService {

    public List<RoadClosure> getRoadClosures() {
        final RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<RoadClosure>> coaResponse =
                restTemplate.exchange("https://data.austintexas.gov/resource/8xxj-ec43.json",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<RoadClosure>>() {
                        });
        List<RoadClosure> roadClosures = coaResponse.getBody();

        log.info("road closures = {}", roadClosures.size());
        return roadClosures;
    }

}
