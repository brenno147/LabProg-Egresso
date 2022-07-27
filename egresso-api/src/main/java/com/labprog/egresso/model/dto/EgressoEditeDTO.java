package com.labprog.egresso.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EgressoEditeDTO {
    private String nome;
    private String email;
    private String cpf;
    private String resumo;
    private String urlFoto;
    private String senha;
    private List<ContatoDTO> contatos;
    private List<CursoDTO> cursos;
    private List<ProfEgressoDTO> profissoes;
    private List<DepoimentoDTO> depoimentos;
}
