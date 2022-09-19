package io.github.marlonrcfranco.vowels;

import io.github.marlonrcfranco.vowels.io.FileUtils;
import io.github.marlonrcfranco.vowels.service.VowelService;

public class Main {

    public static void main(String[] args) {
        String[] text = FileUtils.readInput();
        VowelService vowelService = new VowelService();
        FileUtils.writeOutput(vowelService.getAverageNumberVowels(text));
    }
}
