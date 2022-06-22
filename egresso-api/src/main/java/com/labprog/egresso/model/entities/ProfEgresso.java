package com.labprog.egresso.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "prof_egresso")
public class ProfEgresso {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_prof_egresso")
    private Long idProfEgresso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "egresso_id")
    private Egresso egresso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faixa_salario_id")
    private FaixaSalario faixaSalario;

    @Column(name = "empresa")
    private String empresa;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "data_registro")
    private LocalDate dataRegistro;
}
