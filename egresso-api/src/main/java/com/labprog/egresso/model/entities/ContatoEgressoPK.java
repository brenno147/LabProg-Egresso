package com.labprog.egresso.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Embeddable
public class ContatoEgressoPK implements Serializable {

    @Column(name="egresso_id")
    private Integer egresso_id;

    @Column(name="contato_id")
    private Integer contato_id;
}
