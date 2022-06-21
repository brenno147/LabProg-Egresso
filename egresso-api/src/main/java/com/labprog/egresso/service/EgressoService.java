package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.*;
import com.labprog.egresso.model.repositories.*;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class EgressoService {
    @Autowired
    EgressoRepository egressoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    ContatoRepository contatoRepository;

    @Autowired
    CargoRepository cargoRepository;

    @Autowired
    FaixaSalarioRepository faixaSalarioRepository;


    @Transactional
    public Egresso salvar(Egresso egresso) {

        egresso.setContatos(egresso.getContatos());

        for(CursoEgresso cursoEgresso : egresso.getDatasCursos()){
            egresso.addCurso(cursoEgresso);

            cursoRepository.save(cursoEgresso.getCurso());
        }

        for(ProfEgresso profEgresso : egresso.getProfissao()){

            egresso.addProfissao(profEgresso);

            cargoRepository.save(profEgresso.getCargo());
            faixaSalarioRepository.save(profEgresso.getFaixaSalario());
        }

        return egressoRepository.save(egresso);
    }

    public Egresso findById(Long id) {
        return egressoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));
    }
}
