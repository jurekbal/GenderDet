package com.balwinski.genderdet.services;

import com.balwinski.genderdet.data.FirstTokenFinder;
import com.balwinski.genderdet.data.TokenResults;
import com.balwinski.genderdet.data.TokensFinder;
import org.springframework.stereotype.Service;

@Service
public class FirstTokenGenderDetector implements GenderDetector{

    private final TokensFinder tokenFinder = new FirstTokenFinder();

    @Override
    public String detect(String fullName) {
        if(fullName == null || fullName.isBlank()) {
            return "INCONCLUSIVE";
        }

        TokenResults results = tokenFinder.find(fullName);
        int malesAdvantage = results.getMalesCount() - results.getFemalesCount();

        if (malesAdvantage > 0) {
            return "MALE";
        } else if (malesAdvantage < 0) {
            return "FEMALE";
        } else {
            return "INCONCLUSIVE";
        }
    }
}
