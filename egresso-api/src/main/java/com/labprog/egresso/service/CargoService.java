package com.labprog.egresso.service;

import java.util.List;

import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.repositories.CargoRepository;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service

public class CargoService {

    @Autowired 
    private CargoRepository cargRep;

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
    
    //consultar cargo por egresso
    public List<Cargo> consultarCargoPorEgresso(Long id){
        Egresso egresso = egRep.findById(id).orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));
        List<Long> cargo_ids = cargRep.cargoPorEgresso(egresso);
        List<Cargo> cargos = cargRep.findAllById(cargo_ids);
        return cargos;
    }


    //quantitativo de egressos por cargo
    public List<CargoNumEgresso> quantEgressoPorCargo(){
        List<CargoNumEgresso> quantEgressosCargo = cargRep.numEgressoPorCargo();
        return quantEgressosCargo;
    }

    //verificar id
    private void verificarId(Cargo cargo) {
        if ((cargo == null) || (cargo.getId() == null))
            throw new RegraNegocioException("Posicao sem id");
    }
    // verificar cargo
    private void verificarCargo(Cargo cargo){
        if(cargo == null)
            throw new RegraNegocioException("O cargo é inválido");
        if((cargo.getNome() == null) || (cargo.getNome().equals(' ')))
            throw new RegraNegocioException("O nome do cargo não está preenchido corretamente");
        if((cargo.getDescricao() == null) || (cargo.getDescricao().equals(' ')))
            throw new RegraNegocioException("A descrição do cargo não está preenchida corretamente");
    }

    public Cargo buscarPorId(Long idFaixaSalario) {
        return cargRep.findById(idFaixaSalario)
                .orElseThrow(() -> new RegraNegocioException("Faixa de salário não encontrada"));
    }
}
