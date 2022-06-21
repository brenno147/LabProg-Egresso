package com.labprog.egresso.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany
    @JoinTable(name = "contato_egresso",
            joinColumns = @JoinColumn(name = "egresso_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id"))
    private List<Contato> contatos = new ArrayList<>();

    @OneToMany(mappedBy = "egresso", cascade = CascadeType.ALL)
    private List<ProfEgresso> profissao = new ArrayList<>();

    @OneToMany(mappedBy = "egresso", cascade = CascadeType.ALL)
    private List<CursoEgresso> datasCursos = new ArrayList<>();

    public void addProfissao(ProfEgresso profissao){
        profissao.setEgresso(this);
        this.getProfissao().add(profissao);
    }


    public void addCurso(CursoEgresso cursoEgresso){
        cursoEgresso.setEgresso(this);
        this.getDatasCursos().add(cursoEgresso);
    }

}
