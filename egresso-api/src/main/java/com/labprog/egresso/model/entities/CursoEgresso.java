package com.labprog.egresso.model.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEgresso")
  @JsonIdentityReference(alwaysAsId = true)
  @MapsId("egresso_id")
  @JoinColumn(name="egresso_id")
  private Egresso egresso;

  @ManyToOne(fetch = FetchType.LAZY)
  @MapsId("curso_id")
  @JoinColumn(name="curso_id")
  private Curso curso;

  @Column(name = "data_inicio")
  private LocalDate data_inicio;

  @Column(name = "data_conclusao")
  private LocalDate data_conclusao;
}
