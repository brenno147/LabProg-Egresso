package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Depoimento;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.CargoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {
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
    }
}
