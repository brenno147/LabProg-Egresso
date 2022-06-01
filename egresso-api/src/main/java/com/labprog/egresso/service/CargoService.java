package com.labprog.egresso.service;

import java.util.List;


import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;

import com.labprog.egresso.model.repositories.CargoRepository;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioRunTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service

public class CargoService {

    @Autowired 
    CargoRepository cargRep;

    @Autowired
    EgressoRepository egRep;

    // Salvar
    @Transactional
    public Cargo salvar(Cargo cargo){
        verificarCargo(cargo);
        return cargRep.save(cargo);
    }
    //Editar
    public Cargo editar(Cargo cargo){
        verificarId(cargo);
        return salvar(cargo);
    }

    // deletar
    public void deletar(Cargo cargo){
        verificarId(cargo);
        cargRep.delete(cargo);
    }
    
    // consultar cargo por egresso
    public List<Egresso> consultarCargoPorEgresso(Cargo cargo){
        List<Long> lista_egressos = cargRep.cargoEgresso(cargo);
        List<Egresso> egressos = egRep.findAllById(lista_egressos);
        return egressos;
    }

    // quantitativo de egressos em um cargo
    public int quantEgressoPorCargo(Cargo cargo){
        verificarId(cargo);
        int quantEgressos = cargRep.quantEgressoCargo(cargo);
        return quantEgressos;
    }

    //verificar id
    private void verificarId(Cargo cargo) {
        if ((cargo == null) || (cargo.getId() == null))
            throw new RegraNegocioRunTime("Posicao sem id");
    }
    // verificar cargo
    private void verificarCargo(Cargo cargo){
        if(cargo == null)
            throw new RegraNegocioRunTime("O cargo é inválido");
        if((cargo.getNome() == null) || (cargo.getNome().equals(' ')))
            throw new RegraNegocioRunTime("O nome do cargo não está preenchido corretamente");
        if((cargo.getDescricao() == null) || (cargo.getDescricao().equals(' ')))
            throw new RegraNegocioRunTime("A descrição do cargo não está preenchida corretamente");
    }
}
