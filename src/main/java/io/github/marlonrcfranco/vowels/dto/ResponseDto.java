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
}
