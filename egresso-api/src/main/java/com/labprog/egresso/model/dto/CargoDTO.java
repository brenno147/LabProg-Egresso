package com.labprog.egresso.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
public class CargoDTO {
    private String nome;
    private String descricao;

}
