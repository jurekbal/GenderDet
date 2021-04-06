package com.balwinski.genderdet.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MultiTokenFinder implements TokensFinder{
    private static final String NAME_PARTS_SPLIT_REGEX = "[ -]";

    @Override
    public TokenResults find(String name) {
        if (name == null || name.isBlank()) {
            return new TokenResults(0,0);
            // TODO log invalid parameter for debug - should be filtered in upper layer
        }

        int malesFound = 0;
        int femalesFound = 0;

        String[] nameParts = name.split(NAME_PARTS_SPLIT_REGEX);

        InputStream maleTokensResource = getClass().getClassLoader().getResourceAsStream("given_names_M_PL_reduced.txt");
        InputStream femaleTokensResource = getClass().getClassLoader().getResourceAsStream("given_names_F_PL_reduced.txt");

        try (BufferedReader brMales = new BufferedReader(new InputStreamReader(maleTokensResource, StandardCharsets.UTF_8));
             BufferedReader brFemales = new BufferedReader(new InputStreamReader(femaleTokensResource, StandardCharsets.UTF_8))){

            String token;

            while((token = brMales.readLine()) != null) {
                token = token.strip(); //prevents whitespaces in tokens in case of low quality token files
                for (String namePart : nameParts) {
                    if (token.equalsIgnoreCase(namePart)) {
                        malesFound++;
                    }
                }
            }

            while((token = brFemales.readLine()) != null) {
                token = token.strip(); //prevents whitespaces in tokens in case of low quality token files
                for (String namePart : nameParts) {
                    if (token.equalsIgnoreCase(namePart)) {
                        femalesFound++;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TokenResults(malesFound, femalesFound);
    }
}
