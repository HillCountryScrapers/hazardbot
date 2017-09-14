package com.corelogic.hazardbot.notifier;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
@Slf4j
public class CoaRoadClosureRepository implements RoadClosureRepository {

    private final CoaRoadClosureRestService coaRoadClosureRestService;
    List<RoadClosure> existingRoadClosure = new ArrayList<>();

    public CoaRoadClosureRepository(CoaRoadClosureRestService coaRoadClosureRestService) {
        this.coaRoadClosureRestService = coaRoadClosureRestService;
        this.existingRoadClosure = coaRoadClosureRestService.getRoadClosures();
    }

    @Override
    public List<RoadClosure> getNewRoadClosureEvents() {

        final List<RoadClosure> currentRoadClosures = coaRoadClosureRestService.getRoadClosures();

        final Sets.SetView<RoadClosure> difference = Sets.difference(
                new HashSet<>(currentRoadClosures),
                new HashSet<>(this.existingRoadClosure)
        );

        return new ArrayList<>(difference);
    }

}
