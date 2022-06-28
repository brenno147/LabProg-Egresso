package com.labprog.egresso.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "egresso")
public class Egresso {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_egresso")
    private Long idEgresso;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "resumo")
    private String resumo;

    @Column(name = "url_foto")
    private String urlFoto;

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "contato_egresso",
            joinColumns = @JoinColumn(name = "egresso_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private Set<Contato> contatos = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "egresso")
    private Set<ProfEgresso> profissao = new HashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "egresso")
    private Set<CursoEgresso> datasCursos = new HashSet<>();

    public void addProfissao(ProfEgresso profissao){
        profissao.setEgresso(this);
        this.getProfissao().add(profissao);
    }


    public void addCurso(CursoEgresso cursoEgresso){
        cursoEgresso.setEgresso(this);
        this.getDatasCursos().add(cursoEgresso);
    }

}
