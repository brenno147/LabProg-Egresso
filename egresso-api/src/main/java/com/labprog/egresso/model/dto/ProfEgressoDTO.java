package com.labprog.egresso.model.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor

public class ProfEgressoDTO {
    private Long id;
    private Long cargoId;
    private Long faixaSalarioId;
    private String empresa;
    private String descricao;
    private LocalDate dataRegistro;
}
