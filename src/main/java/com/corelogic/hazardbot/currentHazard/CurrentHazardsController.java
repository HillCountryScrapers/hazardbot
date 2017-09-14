package com.corelogic.hazardbot.currentHazard;

import com.corelogic.hazardbot.Event;
import com.corelogic.hazardbot.notifier.CoaRoadClosureRepository;
import com.corelogic.hazardbot.notifier.RoadClosure;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

@RequestMapping("/currentHazards")
@Controller
@Slf4j
public class CurrentHazardsController {
    private final CoaRoadClosureRepository coaRoadClosureRepository;

    public CurrentHazardsController(CoaRoadClosureRepository coaRoadClosureRepository) {
        this.coaRoadClosureRepository = coaRoadClosureRepository;
    }

    @GetMapping
    @SneakyThrows
    public String getCurrentHazards(@RequestParam(required = false) String postalCode,
                                    Model model) {
        model.addAttribute("postalCode", postalCode);

        if (postalCode == null) {
            model.addAttribute("events", emptyList());
        } else {
            final List<RoadClosure> roadClosures = coaRoadClosureRepository.getAllRoadClosureEvents();

            final List<Event> events = roadClosures.stream()
                .filter(roadClosure -> postalCode.equals(roadClosure.getPostalCode()))
                .map(RoadClosure::getEvent)
                .sorted(Comparator.comparing(Event::getContent))
                .collect(Collectors.toList());

            model.addAttribute("events", events);
        }

        return "currentHazards";
    }
}
