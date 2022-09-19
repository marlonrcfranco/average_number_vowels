package io.github.marlonrcfranco.vowels.service;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import io.github.marlonrcfranco.vowels.dto.VowelKeyDto;
import io.github.marlonrcfranco.vowels.dto.VowelValueDto;
import io.github.marlonrcfranco.vowels.mapper.ResponseMapper;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@NoArgsConstructor
public class VowelService {

    public List<ResponseDto> getAverageNumberVowels(String[] text) throws IllegalArgumentException {
        if (text == null) throw new IllegalArgumentException();

        Map<VowelKeyDto, VowelValueDto> response = new HashMap<>();

        for (String word : text) {
            word = sanitize(word);
            List<Character> vowels = getVowels(word);
            VowelKeyDto key = generateKey(vowels, word.length());
            VowelValueDto oldValue = Optional.ofNullable(response.get(key))
                    .orElse(VowelValueDto.builder()
                            .wordCounter(0)
                            .vowelCounter(0)
                            .build());
            VowelValueDto value = generateValue(key, vowels.size(), oldValue);
            response.put(key, value);
        }
        return response.keySet().stream()
                .map(key -> ResponseMapper.fromVowelDto(key,response.get(key)))
                .collect(Collectors.toList());
    }

    private String sanitize(String word) {
        return word.replaceAll("[^A-Za-z0-9]", "");
    }

    private List<Character> getVowels(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".indexOf(c) > -1)
                .toList();
    }

    private VowelKeyDto generateKey(List<Character> vowels, Integer wordLength) {
        return VowelKeyDto.builder()
                .vowels(new HashSet<>(vowels))
                .wordLength(wordLength)
                .build();
    }

    private VowelValueDto generateValue(VowelKeyDto key, Integer numVowels, VowelValueDto oldValue) {
        if (key == null || key.getVowels() == null) {
            throw new IllegalArgumentException();
        }
        Integer wordCounter = oldValue.getWordCounter() + 1;
        Integer vowelCounter = oldValue.getVowelCounter() + numVowels;
        return VowelValueDto.builder()
                .wordCounter(wordCounter)
                .vowelCounter(vowelCounter)
                .averageNumberVowels(getAverage(vowelCounter, wordCounter))
                .build();
    }

    private Double getAverage(Integer vowelCounter, Integer wordCounter) throws IllegalArgumentException {
        if (wordCounter == null || wordCounter <= 0) {
            throw new IllegalArgumentException();
        }
        return (double) vowelCounter / (double) wordCounter;
    }
}
