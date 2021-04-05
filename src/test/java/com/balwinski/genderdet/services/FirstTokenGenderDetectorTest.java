package com.balwinski.genderdet.services;

import com.balwinski.genderdet.data.FirstTokenFinder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.balwinski.genderdet.constants.TestDataConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class FirstTokenGenderDetectorTest {

    private static GenderDetector gd;

    @BeforeAll
    static void setup(){
        //given
        gd = new FirstTokenGenderDetector();
    }

    @Test
    void haveToReturnMALE() {

        //when
        //then
        for (String name : MALE_NAMES_SAMPLE) {
            assertThat(gd.detect(name)).isEqualTo("MALE");
        }
    }

    @Test
    void haveToReturnFEMALE() {
        //when
        //then
        for (String name : FEMALE_NAMES_SAMPLE) {
            assertThat(gd.detect(name)).isEqualTo("FEMALE");
        }
    }

    @Test
    void haveToReturnINCONCLUSIVE() {
        //when
        //then
        for (String name : NOT_NAMES) {
            assertThat(gd.detect(name)).isEqualTo("INCONCLUSIVE");
        }
    }

}