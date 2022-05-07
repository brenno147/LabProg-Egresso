package com.labprog.egresso.model.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
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

  private LocalDate data_inicio;

  private LocalDate data_conclusao;
}
