package com.corelogic.hazardbot.subscriber;

import org.junit.Test;

import static org.assertj.core.api.BDDAssertions.then;

public class PhoneNumberFormatterTest {
    @Test
    public void format() throws Exception {
        final PhoneNumberFormatter subject = new PhoneNumberFormatter();

        then(subject.format("5127697909")).isEqualTo("512-769-7909");
    }

    @Test
    public void strip() throws Exception {
        final PhoneNumberFormatter subject = new PhoneNumberFormatter();

        then(subject.strip("512-769-7909")).isEqualTo("5127697909");
        then(subject.strip("5127697909")).isEqualTo("5127697909");
    }
}
