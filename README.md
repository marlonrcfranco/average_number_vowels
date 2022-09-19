# average_number_vowels
Retrieve the average number of vowels per word in a .txt input

Given the supplied text file (INPUT.TXT), write a Java program that loads all words and determines the average number of vowels per word grouped by:
set of vowels present in a word and length of the word. Result should be written to the output file (OUTPUT.TXT).

Assumptions:
1.      Capital and lower case letter should be treated as the same.
2.      Input contains only English words and punctuation, words are separated by at least one whitespace character.
3.      Input is small enough to fit in memory.

Example:

INPUT:
```
Platon made bamboo boats.
```

OUTPUT:
```
({a, o}, 6) -> 2.5
({a, o}, 5) -> 2
({a, e}, 4) -> 2
```
