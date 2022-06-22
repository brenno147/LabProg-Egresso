package com.labprog.egresso.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CursoDto {

    private String nome;
    private String nivel;
}
