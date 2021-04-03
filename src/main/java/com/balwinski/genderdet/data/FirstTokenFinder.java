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
        int malesFound = 0;
        int femalesFound = 0;

        String[] nameParts = name.split(" ");
        String givenName = nameParts[0];

        Path malesFilePath = FileSystems.getDefault().getPath("given_names_M_PL_reduced.txt");
        Path femalesFilePath = FileSystems.getDefault().getPath("given_names_F_PL_reduced.txt");

        try (BufferedReader brMales = new BufferedReader(Files.newBufferedReader(malesFilePath, StandardCharsets.UTF_8));
             BufferedReader brFemales = new BufferedReader(Files.newBufferedReader(femalesFilePath, StandardCharsets.UTF_8))) {

            String maleLine;
            String[] maleParts;
            while((maleLine = brMales.readLine()) != null) {
                maleParts = maleLine.split(" ");
                if (maleParts[0].equalsIgnoreCase(givenName)) {
                    malesFound++;
                    break;
                }
            }

            String femaleLine;
            String[] femaleParts;
            while((femaleLine = brFemales.readLine()) != null) {
                femaleParts = femaleLine.split(" ");
                if (femaleParts[0].equalsIgnoreCase(givenName)) {
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
