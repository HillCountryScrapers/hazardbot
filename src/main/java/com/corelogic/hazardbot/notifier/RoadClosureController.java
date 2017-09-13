package com.corelogic.hazardbot.notifier;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController("/api/roadclosures")
public class RoadClosureController {

    private MockRoadClosureRepository mockRoadClosureRepository;

    public RoadClosureController(MockRoadClosureRepository mockRoadClosureRepository) {
        this.mockRoadClosureRepository = mockRoadClosureRepository;
    }

    @GetMapping()
    ResponseEntity<List<RoadClosure>> get() {
        final List<RoadClosure> body = mockRoadClosureRepository.get();
        log.info(Arrays.toString(body.toArray()));
        return ResponseEntity.ok(body);
    }

    @PostMapping()
    ResponseEntity post(@RequestBody RoadClosure roadClosure) {
        mockRoadClosureRepository.add(roadClosure);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

