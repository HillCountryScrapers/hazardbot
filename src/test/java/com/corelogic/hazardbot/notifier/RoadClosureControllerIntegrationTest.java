package com.corelogic.hazardbot.notifier;


import com.corelogic.hazardbot.HazardbotApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ActiveProfiles("mock")
@SpringBootTest(classes = HazardbotApplication.class)
public class RoadClosureControllerIntegrationTest {

    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    public void testcontroller() throws Exception {
        final MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/api/roadclosures")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .content("{\"location\":\"blah\",\"crossStreets\":\"blahblah\"}")
                )
                .andDo(print())
                .andExpect(status().isCreated());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/roadclosures"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"location\":\"blah\",\"crossStreets\":\"blahblah\"}]"));
    }
}