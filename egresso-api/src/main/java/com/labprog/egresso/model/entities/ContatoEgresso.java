package com.labprog.egresso.model.entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contato_egresso")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContatoEgresso {

    @EmbeddedId
    private ContatoEgressoPK id;

    @ManyToOne
    @MapsId("egresso_id")
    @JoinColumn(name="id_egresso")
    private Egresso egresso;

    @ManyToOne
    @MapsId("contato_id")
    @JoinColumn(name="contato_id")
    private Contato contato;
    
}
