package com.balwinski.genderdet.services;

import org.junit.jupiter.api.Test;

import static com.balwinski.genderdet.services.TestDataConstants.*;
import static org.assertj.core.api.Assertions.assertThat;

class FirstTokenGenderDetectorTest {

    @Test
    void haveToReturnMALE() {
        //given
        GenderDetector gd = new FirstTokenGenderDetector();
        //when
        //then
        for (String name : MALE_NAMES_SAMPLE) {
            assertThat(gd.detect(name)).isEqualTo("MALE");
        }
    }

    @Test
    void haveToReturnFEMALE() {
        //given
        GenderDetector dg = new FirstTokenGenderDetector();
        //when
        //then
        for (String name : FEMALE_NAMES_SAMPLE) {
            assertThat(dg.detect(name)).isEqualTo("FEMALE");
        }
    }

    @Test
    void haveToReturnINCONCLUSIVE() {
        //given
        GenderDetector dg = new FirstTokenGenderDetector();
        //when
        //then
        for (String name : NOT_NAMES) {
            assertThat(dg.detect(name)).isEqualTo("INCONCLUSIVE");
        }
    }

}