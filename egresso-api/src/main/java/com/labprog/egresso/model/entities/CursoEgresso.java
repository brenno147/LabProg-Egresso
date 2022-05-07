package com.labprog.egresso.model.entities;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "curso_egresso")
public class CursoEgresso {

  @EmbeddedId
  CursoEgressoPK id;

  @ManyToOne
  @JoinColumn(name="egresso_id")
  private Egresso egresso;

  @ManyToOne
  @JoinColumn(name="curso_id")
  private Curso curso;

  private LocalDate data_inicio;

  private LocalDate data_conclusao;
}
