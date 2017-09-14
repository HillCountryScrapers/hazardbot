package com.corelogic.hazardbot.notifier;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StubRoadClosureRepository implements  RoadClosureRepository {

    private List<RoadClosure> roadClosures = new ArrayList<>();

    public void add(RoadClosure roadClosure) {
        roadClosures.add(roadClosure);
    }

    @Override
    public List<RoadClosure> getNewRoadClosureEvents() {
        return roadClosures;
    }
}