package com.balwinski.genderdet.data;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class FirstTokenFinderTest {

    //TODO Female, inconclusive cases

    @Test
    void shouldProduceOneMaleFoundResult() {
        //given
        TokensFinder tf = new FirstTokenFinder();
        //when
        TokenResults results = tf.find("piotr nowak");
        //then
        assertThat(results).isNotNull();
        assertThat(results.getMalesCount()).isEqualTo(1).as("Males count match/dismatch");
        assertThat(results.getFemalesCount()).isEqualTo(0).as("Females count match/dismatch");

        // TODO change to parametrized test and implement more test cases
    }
}