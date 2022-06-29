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
public class DepoimentoDTO {
    private Long idEgresso;
    private String texto;
    private LocalDate data;

}
