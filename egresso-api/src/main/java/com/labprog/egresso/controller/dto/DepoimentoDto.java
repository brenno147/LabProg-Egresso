package com.labprog.egresso.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class DepoimentoDto {

    private Long idEgresso;
    private String texto;
    private LocalDate data;
}
