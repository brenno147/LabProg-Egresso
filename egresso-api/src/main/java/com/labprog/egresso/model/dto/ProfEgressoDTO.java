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
<<<<<<< HEAD
=======

>>>>>>> 9ea5707fd710713931c976de2fa56ef858878e91
public class ProfEgressoDTO {
    private Long id;
    private Long cargoId;
    private Long faixaSalarioId;
    private String empresa;
    private String descricao;
    private LocalDate dataRegistro;
}
