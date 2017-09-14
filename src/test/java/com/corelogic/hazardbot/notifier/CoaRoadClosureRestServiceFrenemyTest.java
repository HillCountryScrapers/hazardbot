package com.corelogic.hazardbot.notifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CoaRoadClosureRestServiceFrenemyTest {

    @Autowired
    CoaRoadClosureRestService coaRoadClosureRestService;

    @Test
    public void getRoadClosures_callsCityOfAustin() throws Exception {

        final List<RoadClosure> roadClosures = coaRoadClosureRestService.getRoadClosures();

        assertThat(roadClosures.size(), greaterThan(1));
        assertThat(roadClosures.get(0).getPostalCode(), notNullValue());
    }
}
