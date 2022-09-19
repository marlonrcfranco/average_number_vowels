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

Explanation:
```
5 vowels in 2 words ("Platon", "bamboo") = 5/2 = 2.5
2 vowels in 1 word ("boats") = 2/1 = 2
2 vowels in 1 word ("made") = 2/1 = 2
```

Inicializar dois HashMaps:
   key -> value
 ({vowels}, wordLength) -> (wordCounter, averageNumberVowels)


Para cada palavra na lista:
 - Gerar a chave (key):
   - obter as vogais da palavra
   - obter o tamanho da palavra
 - Inserir no HashMap:
   - Incrementa o contador no HashMap para a key gerada
   - Calcular a media de vogais por palavras encontradas e amazenar no averageNumberVowels

