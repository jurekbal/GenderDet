# Genderdet

A simple Java gender detection application by given name.

## Description

Guess gender detection algorithm is fairly simple and is based on a list of female and male tokens.
Those lists are in the form of two flat files, where each line contains a separate token.
For each name, the app responds either with gender or “INCONCLUSIVE”. 

The gender detection algorithm will be implemented in two variants:
* Only first token of name is checked:
* All tokens are checked and majority rule is used

Application will expose two HTTP endpoints: one for using the gender guessing with selected variant 
and one for returning available tokens for each gender. 
First endpoint accepts a name as a single string. Gender detection algorithm type parameter can be passed in any form.

## Endpoints

Simple detection by first word of tested name is available at:
/genderdet/first/{name}

Multitoken detector is exposed at:
/genderdet/multi/{name}

{name} - full name to be tested

Application is listening at port 8080.

Endpoint returns flat Strings of 3 type according to algorithm result:
MALE, FEMALE, INCONCLUSIVE


## How to build and use

1. Run entrypoint class GenderdetApplication.main() from your favorite IDE
2. Build using Maven: mvn clean install
3. then run jar file (should be found in target directory): java -jar genderdet-<version>.jar  (where <version> is 
   current verion like 1.0-SNAPSHOT or 1.0-RELEASE)
   
4. Shoot endpoint with your request
   

## Version History

Development 1.0 (pre-release) genderdet-1.0-SNAPSHOT - version meets task requirements.

## Resources

Embedded token files are two lists of given names occurring in Poland, reduced to names that occurs 
more than 89 for males and more than 79 times for females in government's statistics.

Source: https://dane.gov.pl/pl/dataset/1667,lista-imion-wystepujacych-w-rejestrze-pesel-osoby-zyjace

## License

This project is licensed under the MIT License - see the LICENSE.md file for details

## Authors

Jerzy Balwinski