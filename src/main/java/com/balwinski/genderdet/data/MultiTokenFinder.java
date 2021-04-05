package com.balwinski.genderdet.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

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

        Path malesFilePath = FileSystems.getDefault().getPath("given_names_M_PL_reduced.txt");
        Path femalesFilePath = FileSystems.getDefault().getPath("given_names_F_PL_reduced.txt");

        try (BufferedReader brMales = new BufferedReader(Files.newBufferedReader(malesFilePath, StandardCharsets.UTF_8));
             BufferedReader brFemales = new BufferedReader(Files.newBufferedReader(femalesFilePath, StandardCharsets.UTF_8))) {

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
