package com.labprog.egresso.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor

public class CursoEgressoDTO {
    private Long id;
    private Long cursoId;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
}
