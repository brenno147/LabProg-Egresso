package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Depoimento;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.CargoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class CargoService2 {
    @Autowired
    private CargoRepository cargoRepository;

    public Cargo salvar(Cargo cargo){
        return cargoRepository.save(cargo);
    }

    public void remover(Long id){
        cargoRepository.deleteById(id);
    }

    public List<Cargo> cargoPorEgresso(Egresso egresso){
        return cargoRepository.cargoPorEgresso(egresso);
    }



    public Cargo findById(Long id){
        return cargoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Cargo não encontrado"));
>>>>>>> 3a9b435af3b56bf0b029024a2d4e370f85573b8b
    }
}
