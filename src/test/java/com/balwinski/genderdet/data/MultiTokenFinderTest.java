package com.balwinski.genderdet.data;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.balwinski.genderdet.constants.TestDataConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class MultiTokenFinderTest {

    private static TokensFinder tokenFinder;

    @BeforeAll
    static void setup() {
        //given
        tokenFinder = new MultiTokenFinder();
    }

    @Test
    void shouldProduceGreaterMaleCount() {

        for (String fullName : MALE_NAMES_SAMPLE) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males count < females count for name: " + fullName)
                    .isGreaterThan(results.getFemalesCount());
//            System.out.println(fullName + " M:" + results.getMalesCount() + " F:" + results.getFemalesCount());
        }
    }

    @Test
    void shouldProduceGreaterFemaleCount() {

        for (String fullName : FEMALE_NAMES_SAMPLE) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getFemalesCount()).as("Females count < males count for name: " + fullName)
                    .isGreaterThan(results.getMalesCount());
//            System.out.println(fullName + " M:" + results.getMalesCount() + " F:" + results.getFemalesCount());
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

    @Test
    void shouldProduceEqualCountsForInconclusiveMaleName() {
        for (String fullName : INCONCLUSIVE_MALE_NAMES_FOR_MULTITOKEN) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males/females count not equal for inconclusive name: " + fullName)
                    .isEqualTo(results.getFemalesCount());
//            System.out.println(fullName + " M:" + results.getMalesCount() + " F:" + results.getFemalesCount());
        }
    }

    @Test
    void shouldProduceEqualCountsForInconclusiveFemaleName() {
        for (String fullName : INCONCLUSIVE_FEMALE_NAMES_FOR_MULTITOKEN) {
            //when
            TokenResults results = tokenFinder.find(fullName);
            //then
            assertThat(results).isNotNull();
            assertThat(results.getMalesCount()).as("Males/females count not equal for inconclusive name: " + fullName)
                    .isEqualTo(results.getFemalesCount());
//            System.out.println(fullName + " M:" + results.getMalesCount() + " F:" + results.getFemalesCount());
        }
    }
}