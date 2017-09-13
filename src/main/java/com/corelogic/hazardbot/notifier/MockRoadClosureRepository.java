package com.corelogic.hazardbot.notifier;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockRoadClosureRepository {

    private List<RoadClosure> roadClosures = new ArrayList<>();

    public void add(RoadClosure roadClosure) {
        roadClosures.add(roadClosure);
    }

    public List<RoadClosure> get() {
        return roadClosures;
    }
}