package io.github.marlonrcfranco.vowels.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.Value;

/**
 * Example: (1, 2)
 */
@Data
@Builder
public class VowelValueDto {
    @ToString.Exclude
    private Integer wordCounter;
    private Double averageNumberVowels;
}
