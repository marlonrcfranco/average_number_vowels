package io.github.marlonrcfranco.vowels;

import io.github.marlonrcfranco.vowels.dto.ResponseDto;
import io.github.marlonrcfranco.vowels.io.FileUtils;
import io.github.marlonrcfranco.vowels.service.VowelService;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        String readFile = args.length > 0 && args[0] != null ? args[0] : "src/test/resources/INPUT.TXT";
        String writeFile = args.length > 1 && args[1] != null ? args[1] : "src/test/resources/OUTPUT.TXT";
        String[] text = FileUtils.readInput(readFile);
        VowelService vowelService = new VowelService();
        List<ResponseDto> response = vowelService.getAverageNumberVowels(text);
        FileUtils.writeOutput(response, writeFile);
    }
}
