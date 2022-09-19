package io.github.marlonrcfranco.vowels.io;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import io.github.marlonrcfranco.vowels.dto.VowelKeyDto;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class FileUtils {

    public static String[] readInput() {
        return readInput("INPUT.TXT");
    }

    public static String[] readInput(String inputFile) {
        return null;
    }

    public static void writeOutput(List<ResponseDto> output) {
        writeOutput(output, "OUTPUT.TXT");
    }

    public static void writeOutput(List<ResponseDto> output, String outputFile) {

    }

}
