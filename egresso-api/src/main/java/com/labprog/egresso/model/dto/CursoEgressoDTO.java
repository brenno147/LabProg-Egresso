package com.labprog.egresso.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CursoEgressoDTO {
    private Long id;
    private Long cursoId;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
}
