package io.github.marlonrcfranco.vowels.service;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class VowelServiceTest {

    private VowelService service;

    @BeforeAll
    public void init() {
        service = new VowelService();
    }

    @Test
    public void test_getAverageNumberVowels_success() {
        String text = ".Platon. made bamboo boats.";
        List<ResponseDto> expected = List.of(
                ResponseDto.builder().vowels(Set.of("a".charAt(0),"o".charAt(0))).wordLength(6).average(2.5).build(),
                ResponseDto.builder().vowels(Set.of("a".charAt(0),"o".charAt(0))).wordLength(5).average(2.0).build(),
                ResponseDto.builder().vowels(Set.of("a".charAt(0),"e".charAt(0))).wordLength(4).average(2.0).build());
        var actual = service.getAverageNumberVowels(text.split(" "));
        assertNotNull(actual);
        assertEquals(expected.size(), actual.size());
        assertTrue(actual.containsAll(expected));
    }
}
