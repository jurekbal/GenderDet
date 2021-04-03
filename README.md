# Genderdet

A simple Java gender detection application by given name.

## Description

(app assumptions)

Guess gender detection algorithm is fairly simple and is based on a list of female and male tokens.
Those lists are in the form of two flat files, where each line contains a separate token.
For each name, the app responds either with gender or “INCONCLUSIVE”. 

The gender detection algorithm will be implemented in two variants:
* Only first token of name is checked:
* All tokens are checked and majority rule is used

Application will expose two HTTP endpoints: one for using the gender guessing with selected variant 
and one for returning available tokens for each gender. 
First endpoint accepts a name as a single string. Gender detection algorithm type parameter can be passed in any form.

## Authors

Jerzy Balwinski

## Version History

early development stage - no releases

## License

This project is licensed under the MIT License - see the LICENSE.md file for details
