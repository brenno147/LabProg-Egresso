package com.labprog.egresso.model.entities;

import java.time.LocalDate;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@Table(name = "depoimento")
public class Depoimento {
  
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Long id_depoimento;


  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "egresso_id")
  @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idEgresso")
  @JsonIdentityReference(alwaysAsId = true)
  private Egresso egresso;

  @Column(name = "texto")
  private String texto;

  @Column(name = "data")
  private LocalDate data;
  
}
