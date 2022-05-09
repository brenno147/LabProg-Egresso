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
@Table(name = "depoimento")
public class Depoimento {
  
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private int id_depoimento;

  @ManyToOne
  @JoinColumn(name = "egresso_id")
  private Egresso egresso;

  private String texto;

  private LocalDate data;
  
}
