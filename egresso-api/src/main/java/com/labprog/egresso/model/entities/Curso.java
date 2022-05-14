package com.labprog.egresso.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
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
  private int id_curso;

  private String nome;

  private String nivel;

  @OneToMany(mappedBy = "curso")
  private List<CursoEgresso> datas_inicio_fim_egressos = new ArrayList<>();

}
