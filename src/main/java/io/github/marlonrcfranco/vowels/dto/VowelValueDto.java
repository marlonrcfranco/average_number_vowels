package io.github.marlonrcfranco.vowels.dto;

import lombok.*;

/**
 * Example: (1, 2)
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VowelValueDto {
    @ToString.Exclude
    private Integer wordCounter;
    @ToString.Exclude
    private Integer vowelCounter;
    private Double averageNumberVowels;
}
