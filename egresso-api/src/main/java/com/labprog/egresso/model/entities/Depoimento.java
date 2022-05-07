package com.labprog.egresso.model.entities;

import java.time.LocalDate;

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
@Table(name = "depoimento")
public class Depoimento {
  
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private int id_depoimento;

  private String texto;

  private LocalDate data;
  
}
