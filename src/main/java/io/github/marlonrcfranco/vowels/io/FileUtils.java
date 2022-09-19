package io.github.marlonrcfranco.vowels.io;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import lombok.experimental.UtilityClass;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@UtilityClass
public class FileUtils {

    public static String[] readInput(String inputFile) throws IOException {
        Scanner input = new Scanner(new FileReader(inputFile));
        List<String> content = new ArrayList<>();
        while(input.hasNext()) {
            content.add(input.next());
        }
        input.close();
        return content.toArray(String[]::new);
    }

    public static void writeOutput(List<ResponseDto> content) {
        try {
            writeOutput(content, "OUTPUT.TXT");
        } catch (IOException e) {
        }
    }

    public static void writeOutput(List<ResponseDto> content, String outputFile) throws IOException {
        List<String> lines = content.stream()
                .map(ResponseDto::toString)
                .collect(Collectors.toList());
        Path file = Paths.get(outputFile);
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

}
