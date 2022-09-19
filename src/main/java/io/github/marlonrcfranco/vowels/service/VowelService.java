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

    public List<ResponseDto> getAverageNumberVowels(String[] text) {
        Map<VowelKeyDto, VowelValueDto> response = new HashMap<>();

        for (String word : text) {
            VowelKeyDto key = generateKey(word);
            VowelValueDto oldValue = Optional.ofNullable(response.get(key))
                    .orElse(VowelValueDto.builder()
                            .wordCounter(0)
                            .build());
            VowelValueDto value = generateValue(key, oldValue);
            response.put(key, value);
        }
        return response.keySet().stream()
                .map(key -> ResponseMapper.fromVowelDto(key,response.get(key)))
                .collect(Collectors.toList());
    }

    private VowelKeyDto generateKey(String word) {
        Set<Character> vowels = word.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> "aeiou".indexOf(c) > -1)
                .collect(Collectors.toSet());
        return VowelKeyDto.builder()
                .vowels(vowels)
                .wordLength(word.length())
                .build();
    }

    private VowelValueDto generateValue(VowelKeyDto key, VowelValueDto oldValue) {
        Integer wordCounter = oldValue.getWordCounter() + 1;
        return VowelValueDto.builder()
                .wordCounter(wordCounter)
                .averageNumberVowels(getAverage(key, wordCounter))
                .build();
    }

    private Double getAverage(VowelKeyDto key, Integer wordCounter) throws IllegalArgumentException {
        if (wordCounter == null || wordCounter <= 0 || key == null || key.getVowels() == null) {
            throw new IllegalArgumentException();
        }
        Integer numVowels = key.getVowels().size();
        return (double) (numVowels / wordCounter);
    }
}
