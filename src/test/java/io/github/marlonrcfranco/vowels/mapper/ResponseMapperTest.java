package io.github.marlonrcfranco.vowels.mapper;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import io.github.marlonrcfranco.vowels.dto.VowelKeyDto;
import io.github.marlonrcfranco.vowels.dto.VowelValueDto;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class ResponseMapperTest {

    @Test
    public void test_fromVowelDto_success() {
        VowelKeyDto key = VowelKeyDto.builder()
                .vowels(Set.of("a".charAt(0),"o".charAt(0)))
                .wordLength(6)
                .build();

        VowelValueDto value = VowelValueDto.builder()
                .averageNumberVowels(2.5)
                .build();

        ResponseDto expected = ResponseDto.builder()
                .vowels(key.getVowels())
                .wordLength(key.getWordLength())
                .average(value.getAverageNumberVowels())
                .build();

        ResponseDto actual = ResponseMapper.fromVowelDto(key, value);

        assertNotNull(actual);
        assertEquals(actual, expected);
    }

    @Test
    public void test_fromVowelDto_nullVowelKeyDto() {
        assertNull(ResponseMapper.fromVowelDto(null, new VowelValueDto()));
    }

    @Test
    public void test_fromVowelDto_nullVowelValueDto() {
        assertNull(ResponseMapper.fromVowelDto(new VowelKeyDto(), null));
    }
}
