package com.corelogic.hazardbot.notification.smsclient;

import com.corelogic.hazardbot.subscriber.Subscriber;
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
        List<Subscriber> phoneNumbers = Arrays.asList(
            new Subscriber("619-625-8494", null, null),
            new Subscriber("281-451-1243", null, null)
        );
        String content = "Something happened!";

        subject.sendSms(phoneNumbers, content);

        // check yo phone
    }
}
