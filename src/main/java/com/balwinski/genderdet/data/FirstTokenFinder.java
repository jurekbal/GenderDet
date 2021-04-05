package com.balwinski.genderdet.data;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

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

        Path malesFilePath = FileSystems.getDefault().getPath("given_names_M_PL_reduced.txt");
        Path femalesFilePath = FileSystems.getDefault().getPath("given_names_F_PL_reduced.txt");

        try (BufferedReader brMales = new BufferedReader(Files.newBufferedReader(malesFilePath, StandardCharsets.UTF_8));
             BufferedReader brFemales = new BufferedReader(Files.newBufferedReader(femalesFilePath, StandardCharsets.UTF_8))) {

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
