package com.labprog.egresso.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder

public class ProfEgressoDTO {
    private Long cargoId;
    private Long faixaSalarioId;
    private String empresa;
    private String descricao;
    private LocalDate dataRegistro;
}
