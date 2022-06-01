package com.labprog.egresso.model.dto;

import com.labprog.egresso.model.entities.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoNumEgresso {
    public Cargo cargo;
    public Integer numEgresso;
}
