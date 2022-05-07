package com.labprog.egresso.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "faixa_salario")
public class FaixaSalario {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id_faixa_salario")
    private Long idFaixaSalario;

    @Column(name = "descricao")
    private String descricao;
}
