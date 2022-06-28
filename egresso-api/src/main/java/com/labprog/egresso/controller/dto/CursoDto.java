package com.labprog.egresso.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
public class CursoDto {

    @NotBlank
    private String nome;
    @NotBlank
    private String nivel;
}
