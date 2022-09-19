package io.github.marlonrcfranco.vowels.mapper;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import io.github.marlonrcfranco.vowels.dto.VowelKeyDto;
import io.github.marlonrcfranco.vowels.dto.VowelValueDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ResponseMapper {

    public static ResponseDto fromVowelDto(VowelKeyDto vowelKeyDto, VowelValueDto vowelValueDto) {
        if (vowelKeyDto == null || vowelValueDto == null) return null;
        return ResponseDto.builder()
                .vowels(vowelKeyDto.getVowels())
                .wordLength(vowelKeyDto.getWordLength())
                .average(vowelValueDto.getAverageNumberVowels())
                .build();
    }
}
