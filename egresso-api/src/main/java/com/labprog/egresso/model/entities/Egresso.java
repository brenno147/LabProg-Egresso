package com.labprog.egresso.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
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

    @JsonIgnore
    @Column(name = "senha")
    private String senha;

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

    @Builder.Default
    @OneToMany(mappedBy = "egresso")
    private Set<Depoimento> depoimento = new HashSet<>();

    public void addDepoimento(Depoimento depoimento){
        depoimento.setEgresso(this);
        this.getDepoimento().add(depoimento);
    }

}
