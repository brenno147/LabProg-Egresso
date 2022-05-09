package com.labprog.egresso.model.entities;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "curso_egresso")
public class CursoEgresso {


  @EmbeddedId
  CursoEgressoPK id;

  @ManyToOne
  @MapsId("egresso_id")
  @JoinColumn(name="id_egresso")
  private Egresso egresso;

  @ManyToOne
  @MapsId("curso_id")
  @JoinColumn(name="curso_id")
  private Curso curso;

  private LocalDate data_inicio;

  private LocalDate data_conclusao;
}
