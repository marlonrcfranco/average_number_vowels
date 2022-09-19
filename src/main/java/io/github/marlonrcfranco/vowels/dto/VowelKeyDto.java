package io.github.marlonrcfranco.vowels.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class VowelKeyDto {

    private Set<String> vowels;
    private Integer wordLength;
    private Double average;

    /**
     * Example: ({a, o}, 6) -> 3
     */
    public String toString() {
        return "(" + vowels + ", " + wordLength + ") -> " + average;
    }
}
