package com.corelogic.hazardbot.notifier;

import java.util.List;

public interface RoadClosureRepository {
    List<RoadClosure> getNewRoadClosureEvents();
    List<RoadClosure> getAllRoadClosureEvents();
}
