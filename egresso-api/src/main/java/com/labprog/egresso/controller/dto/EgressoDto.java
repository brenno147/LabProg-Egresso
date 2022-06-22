package com.labprog.egresso.controller.dto;

import com.labprog.egresso.model.entities.ProfEgresso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class EgressoDto {

    private String nome;
    private String email;
    private String cpf;
    private String resumo;
    private String urlFoto;
    private List<ContatoDto> contatos;
    private List<CursoEgressoDto> cursos;
    private List<ProfEgressoDto> profissoes;
}
