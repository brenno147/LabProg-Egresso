package com.labprog.egresso.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class CursoEgressoDto {
    private Long cursoId;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
}
