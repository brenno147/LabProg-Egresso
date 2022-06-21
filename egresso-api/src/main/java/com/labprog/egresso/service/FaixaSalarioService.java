package com.labprog.egresso.service;

import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.model.entities.FaixaSalario;
import com.labprog.egresso.model.repositories.FaixaSalarioRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaixaSalarioService {

    @Autowired
    private FaixaSalarioRepository faixaSalarioRepository;

    public FaixaSalario salvar(FaixaSalario faixaSalario) {
        return faixaSalarioRepository.save(faixaSalario);
    }

    public void remover(Long faixaSalarioId) {
        faixaSalarioRepository.deleteById(faixaSalarioId);
    }

    public List<SalarioNumEgresso> quantEgressoPorSalario(){
        List<SalarioNumEgresso> quantEgressosSalario = faixaSalarioRepository.numEgressoPorSalario();
        return quantEgressosSalario;
    }

    public FaixaSalario buscarPorId(Long idFaixaSalario) {
        return faixaSalarioRepository.findById(idFaixaSalario)
                .orElseThrow(() -> new RegraNegocioException("Faixa de salário não encontrada"));
    }
}
