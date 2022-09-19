package io.github.marlonrcfranco.vowels.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

/**
 * Example: ({a,o},7)
 */
@Data
@Builder
public class VowelKeyDto {
    private Set<Character> vowels;
    private Integer wordLength;
}
