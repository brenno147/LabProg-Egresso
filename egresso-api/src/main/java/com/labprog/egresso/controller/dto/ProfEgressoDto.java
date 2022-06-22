package com.labprog.egresso.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
public class ProfEgressoDto {
    private Long cargoId;
    private Long faixaSalarioId;
    private String empresa;
    private String descricao;
    private LocalDate dataRegistro;
}
