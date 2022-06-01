package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.*;
import com.labprog.egresso.model.repositories.CursoEgressoRepository;
import com.labprog.egresso.model.repositories.EgressoRepository;
import com.labprog.egresso.model.repositories.ProfEgressoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EgressoService {
    @Autowired
    EgressoRepository egressoRepository;
    @Autowired
    CursoEgressoRepository cursoEgressoRepository;
    @Autowired
    ProfEgressoRepository profEgressoRepository;


    public Egresso salvar(Egresso egresso){

    }

    public Egresso findById(Long id) {
        return egressoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Depoimento não encontrado"));
    }
}
