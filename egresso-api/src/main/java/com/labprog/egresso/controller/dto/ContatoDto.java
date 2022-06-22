package com.labprog.egresso.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ContatoDto {
    private String nome;
    private String url_logo;
}
