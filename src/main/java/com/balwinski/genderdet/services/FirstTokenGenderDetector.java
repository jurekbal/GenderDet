package com.balwinski.genderdet.services;

import org.springframework.stereotype.Service;

@Service
public class FirstTokenGenderDetector implements GenderDetector{

    @Override
    public String detect(String fullName) {
        // basic input check here (null, "", not letter)
        // pass FIRST name to data service
        // process result
        return null;
    }
}
