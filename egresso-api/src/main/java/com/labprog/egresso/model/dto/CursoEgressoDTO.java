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
<<<<<<< HEAD
=======

>>>>>>> 9ea5707fd710713931c976de2fa56ef858878e91
public class CursoEgressoDTO {
    private Long id;
    private Long cursoId;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
}
