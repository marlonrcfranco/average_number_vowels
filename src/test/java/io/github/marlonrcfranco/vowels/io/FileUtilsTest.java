package io.github.marlonrcfranco.vowels.io;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class FileUtilsTest {

    private static final String INPUT_TEST_FILE = "src/test/resources/INPUT.TXT";
    private static final String OUTPUT_TEST_FILE = "src/test/resources/output_test.txt";

    @AfterAll
    public static void deleteTestFile() {
        new File(OUTPUT_TEST_FILE).delete();
    }

    @Test
    public void test_readInput_success() throws IOException {
        String[] expected = "Platon made bamboo boats.".split(" ");
        String[] actual = FileUtils.readInput(INPUT_TEST_FILE);
        assertNotNull(actual);
        assertEquals(expected.length, actual.length);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test_writeOutput_success() throws IOException {
        List<ResponseDto> content = List.of(
                ResponseDto.builder().vowels(Set.of("a".charAt(0),"o".charAt(0))).wordLength(6).average(2.5).build(),
                ResponseDto.builder().vowels(Set.of("a".charAt(0),"o".charAt(0))).wordLength(5).average(2.0).build(),
                ResponseDto.builder().vowels(Set.of("a".charAt(0),"e".charAt(0))).wordLength(4).average(2.0).build());

        FileUtils.writeOutput(content, OUTPUT_TEST_FILE);

        String[] expected = {"({a, o}, 6) -> 2.5", "({a, o}, 5) -> 2.0", "({a, e}, 4) -> 2.0"};
        List<String> contentRead = new ArrayList<>();

        File file = new File(OUTPUT_TEST_FILE);
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\n");
        while (sc.hasNext()) {
            contentRead.add(sc.next().strip());
        }
        sc.close();
        String[] actual = contentRead.toArray(String[]::new);

        assertNotNull(actual);
        assertEquals(expected.length, actual.length);
        assertArrayEquals(expected, actual);
    }
}
