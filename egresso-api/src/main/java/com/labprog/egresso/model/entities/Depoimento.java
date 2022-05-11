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
  private Long id_depoimento;

  @ManyToOne
  @JoinColumn(name = "egresso_id")
  private Egresso egresso;

  @Column(name = "texto")
  private String texto;

  @Column(name = "data")
  private LocalDate data;
  
}
