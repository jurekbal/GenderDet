package com.balwinski.genderdet.data;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
public class FirstTokenFinder implements TokensFinder {

    @Override
    public TokenResults find(String name) {
        if (name == null || name.isBlank()) {
            return new TokenResults(0,0);
            // TODO log invalid parameter for debug - should be filtered in upper layer
        }

        int malesFound = 0;
        int femalesFound = 0;

        String[] nameParts = name.split(" ");
        String givenName = nameParts[0];

        InputStream maleTokensResource = getClass().getClassLoader().getResourceAsStream("given_names_M_PL_reduced.txt");
        InputStream femaleTokensResource = getClass().getClassLoader().getResourceAsStream("given_names_F_PL_reduced.txt");

        try (BufferedReader brMales = new BufferedReader(new InputStreamReader(maleTokensResource, StandardCharsets.UTF_8));
             BufferedReader brFemales = new BufferedReader(new InputStreamReader(femaleTokensResource, StandardCharsets.UTF_8))){

            String token;
            while((token = brMales.readLine()) != null) {
                token = token.strip(); //prevents whitespaces in tokens in case of low quality token files
                if (token.equalsIgnoreCase(givenName)) {
                    malesFound++;
                    break;
                }
            }

            while((token = brFemales.readLine()) != null) {
                if (token.equalsIgnoreCase(givenName)) {
                    femalesFound++;
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new TokenResults(malesFound, femalesFound);
    }
}
