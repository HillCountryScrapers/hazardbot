package com.corelogic.hazardbot.notification.smsclient;

import com.twilio.http.TwilioRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = HazardbotApplication.class)
public class SmsRestClientFrenemyTest {


    @Autowired
    TwilioRestClient twilioRestClient;

    @Autowired
    SmsCredentials smsCredentials;

//    @Rule
//    public ExpectedException thrown = ExpectedException.none();


    //Commenting out test because it will send a sms message to a real phone number on every build
//    @Test
    public void sendSms() throws Exception {
        SmsRestClientImpl subject = new SmsRestClientImpl(twilioRestClient, new MessageCreatorProvider(smsCredentials));
        List<String> phoneNumbers = Arrays.asList("619-625-8494", "281-451-1243");
        String content = "Something happened!";

        subject.sendSms(phoneNumbers, content);

        // check yo phone
    }
}
