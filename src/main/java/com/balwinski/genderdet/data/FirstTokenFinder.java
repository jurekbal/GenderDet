package com.balwinski.genderdet.data;

import org.springframework.stereotype.Service;

@Service
public class FirstTokenFinder implements TokensFinder{
    @Override
    public TokenResults find(String name) {
        //TODO read files and check if first word matches, prepare result
        return null;
    }
}
