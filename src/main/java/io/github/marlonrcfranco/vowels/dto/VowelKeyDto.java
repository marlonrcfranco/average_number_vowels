package io.github.marlonrcfranco.vowels.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * Example: ({a,o},7)
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VowelKeyDto {
    private Set<Character> vowels;
    private Integer wordLength;
}
