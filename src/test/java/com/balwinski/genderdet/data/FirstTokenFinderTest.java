package com.balwinski.genderdet.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static com.balwinski.genderdet.constants.TestDataConstants.*;

class FirstTokenFinderTest {

    @Test
    void shouldProduceOneMaleFoundResult() {
        //given
        TokensFinder tf = new FirstTokenFinder();
        //when, then
        for (String fullName : MALE_NAMES_SAMPLE) {
            //when
            TokenResults results = tf.find(fullName);
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
        //given
        TokensFinder tf = new FirstTokenFinder();
        for (String fullName : FEMALE_NAMES_SAMPLE) {
            //when
            TokenResults results = tf.find(fullName);
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
        //given
        TokensFinder tf = new FirstTokenFinder();
        for (String fullName : NOT_NAMES) {
            //when
            TokenResults results = tf.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males count mismatch for name: " + fullName)
                    .isEqualTo(0);
            assertThat(results.getFemalesCount()).as("Females count mismatch for name: " + fullName)
                    .isEqualTo(0);
        }
    }

}