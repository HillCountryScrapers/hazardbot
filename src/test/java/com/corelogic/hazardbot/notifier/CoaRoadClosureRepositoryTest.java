package com.corelogic.hazardbot.notifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoaRoadClosureRepositoryTest {

    @Mock
    CoaRoadClosureRestService mockCoaRoadClosureRestService;

    @Test
    public void getNewRoadClosureEvents_returnsClosuresNotAlreadyInList() throws Exception {

        List<RoadClosure> oldRoadClosureList = Arrays.asList(
                new RoadClosure("location1", "cross streets1", "78758")
        );
        List<RoadClosure> newRoadClosureList = Arrays.asList(
                new RoadClosure("location1", "cross streets1", "78758"),
                new RoadClosure("location2", "cross streets2", "78758")
        );
        List<RoadClosure> expectedRoadClosureList = Arrays.asList(
                new RoadClosure("location2", "cross streets2", "78758")
        );

        when(mockCoaRoadClosureRestService.getRoadClosures())
                .thenReturn(oldRoadClosureList)
                .thenReturn(newRoadClosureList);

        CoaRoadClosureRepository subject = new CoaRoadClosureRepository(mockCoaRoadClosureRestService);
        assertThat(subject.getNewRoadClosureEvents(), equalTo(expectedRoadClosureList));
    }
}
