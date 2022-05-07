package com.labprog.egresso.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "curso")
public class Curso {
  
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private int id_curso;

  private String nome;

  private String nivel;

}
