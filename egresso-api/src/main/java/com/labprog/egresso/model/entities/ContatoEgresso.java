package com.labprog.egresso.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ContatoEgresso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEgresso {
    @Id
    @Column(name="egresso_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="contato_id")
    private Integer contato_id;
    
    
}
