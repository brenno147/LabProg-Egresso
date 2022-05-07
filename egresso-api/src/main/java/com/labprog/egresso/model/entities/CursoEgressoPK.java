package com.labprog.egresso.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class CursoEgressoPK implements Serializable {
  
  @Column(name="egresso_id")
  int egresso_id;

  @Column(name="curso_id")
  int curso;
  
}
