package com.labprog.egresso.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "contato")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contato {

    @Id
    @Column(name="id_contato")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome")
    private String nome;

    @Column(name="url_logo")
    private String url_logo;

}