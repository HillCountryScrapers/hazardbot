package com.corelogic.hazardbot.notifier;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StubRoadClosureRepository implements RoadClosureRepository {

    private List<RoadClosure> allRoadClosures = new ArrayList<>();
    private List<RoadClosure> newRoadClosures = new ArrayList<>();

    public void add(RoadClosure roadClosure) {
        allRoadClosures.add(roadClosure);
        newRoadClosures.add(roadClosure);
    }

    @Override
    public List<RoadClosure> getNewRoadClosureEvents() {
        List<RoadClosure> roadClosuresToReturn = new ArrayList<>(newRoadClosures);
        newRoadClosures.clear();
        return roadClosuresToReturn;
    }

    @Override
    public List<RoadClosure> getAllRoadClosureEvents() {
        return allRoadClosures;
    }
}
