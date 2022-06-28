package com.labprog.egresso.model.entities;


import javax.persistence.*;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "curso")
public class Curso {
  
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  @Column(name = "id_curso")
  private Long id_curso;

  @Column(name = "nome")
  private String nome;

  @Column(name = "nivel")
  private String nivel;

}
