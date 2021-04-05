package com.balwinski.genderdet.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.balwinski.genderdet.constants.TestDataConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class FirstTokenFinderTest {

    private static TokensFinder tokenFinder;

    @BeforeAll
    static void setup() {
        //given
        tokenFinder = new FirstTokenFinder();
    }

    @Test
    void shouldProduceOneMaleFoundResult() {

        for (String fullName : MALE_NAMES_SAMPLE) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males count mismatch for name: " + fullName)
                    .isEqualTo(1);
            assertThat(results.getFemalesCount()).as("Females count mismatch for name: " + fullName)
                    .isEqualTo(0);
        }
    }

    @Test
    void shouldProduceOneFemaleFoundResult() {

        for (String fullName : FEMALE_NAMES_SAMPLE) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males count mismatch for name: " + fullName)
                    .isEqualTo(0);
            assertThat(results.getFemalesCount()).as("Females count mismatch for name: " + fullName)
                    .isEqualTo(1);
        }
    }

    @Test
    void shouldProduceInconclusiveResultZeroZero() {

        for (String fullName : NOT_NAMES) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males count mismatch for name: " + fullName)
                    .isEqualTo(0);
            assertThat(results.getFemalesCount()).as("Females count mismatch for name: " + fullName)
                    .isEqualTo(0);
        }
    }

}