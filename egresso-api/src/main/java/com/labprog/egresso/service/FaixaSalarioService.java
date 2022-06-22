package com.labprog.egresso.service;

import com.labprog.egresso.model.dto.SalarioNumEgresso;
import com.labprog.egresso.model.repositories.FaixaSalarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaixaSalarioService {

    @Autowired
    private FaixaSalarioRepository faixaSalarioRepository;

    public List<SalarioNumEgresso> quantEgressoPorCurso(){
        List<SalarioNumEgresso> quantEgressosSalario = faixaSalarioRepository.numEgressoPorSalario();
        return quantEgressosSalario;
    }
}
