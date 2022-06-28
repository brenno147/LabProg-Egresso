package com.labprog.egresso.service;

import com.labprog.egresso.model.entities.*;
import com.labprog.egresso.model.repositories.*;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EgressoService {
    @Autowired
    EgressoRepository egressoRepository;

    @Autowired
    ProfEgressoRepository profEgressoRepository;

    @Autowired
    CursoEgressoRepository cursoEgressoRepository;


    @Transactional
    public Egresso salvar(Egresso egresso) {
        // OBS.: deve validar o usuário antes de salvar
        Egresso egressoSalvo = egressoRepository.save(egresso);

        for (ProfEgresso profissoes: egresso.getProfissao()) {
            profEgressoRepository.save(profissoes);
        }

        for (CursoEgresso cursos: egresso.getDatasCursos()) {
            cursoEgressoRepository.save(cursos);
        }

        return egressoSalvo;
    }

    @Transactional
    public void remover(Long egressoId) {
        Egresso egresso = egressoRepository.findById(egressoId)
                .orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));

        for (ProfEgresso profissoes: egresso.getProfissao()) {
            profEgressoRepository.delete(profissoes);
        }

        for (CursoEgresso cursos: egresso.getDatasCursos()) {
            cursoEgressoRepository.delete(cursos);
        }

        egressoRepository.delete(egresso);
    }

    public Egresso findById(Long id) {
        return egressoRepository.findById(id)
                .orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));
    }

    public Egresso egressoPorNome(String nome) {
        return egressoRepository.findByNome(nome);
    }

    // validação da senha
    // editar (com contato, curso, cargo e faixa salarial)
    // consultar egresso obtendo juntamente contato, curso, cargo, faixa salarial
}
