package io.github.marlonrcfranco.vowels.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ResponseDto {

    private Set<Character> vowels;
    private Integer wordLength;
    private Double average;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("(")
                .append(vowels.stream().sorted().toList().toString()
                        .replace("[", "{")
                        .replace("]", "}"))
                .append(", ")
                .append(wordLength)
                .append(") -> ")
                .append(average)
                .toString();
    }
}
