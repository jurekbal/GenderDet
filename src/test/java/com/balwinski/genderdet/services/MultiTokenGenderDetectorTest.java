package com.balwinski.genderdet.services;

import org.junit.jupiter.api.Test;

import static com.balwinski.genderdet.services.TestDataConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MultiTokenGenderDetectorTest {

    @Test
    void haveToReturnMALE() {
        GenderDetector gd = new MultiTokenGenderDetector();

        for (String name : MALE_NAMES_SAMPLE) {
            assertThat(gd.detect(name)).isEqualTo("MALE");
        }
    }

    @Test
    void haveToReturnFEALE() {
        GenderDetector gd = new MultiTokenGenderDetector();

        for (String name : FEMALE_NAMES_SAMPLE) {
            assertThat(gd.detect(name)).isEqualTo("MALE");
        }
    }

    @Test
    void haveToReturnINCONCLUSIVE() {
        GenderDetector gd = new MultiTokenGenderDetector();

        for (String name : NOT_NAMES) {
            assertThat(gd.detect(name)).isEqualTo("INCONCLUSIVE");
        }
        for (String name : INCONCLUSIVE_MALE_NAMES_FOR_MULTITOKEN) {
            assertThat(gd.detect(name)).isEqualTo("INCONCLUSIVE");
        }
        for (String name : INCONCLUSIVE_FEMALE_NAMES_FOR_MULTITOKEN) {
            assertThat(gd.detect(name)).isEqualTo("INCONCLUSIVE");
        }
    }



}