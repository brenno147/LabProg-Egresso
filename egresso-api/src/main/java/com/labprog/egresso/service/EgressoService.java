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

        verificarEgresso(egresso);
        for (ProfEgresso profissoes : egresso.getProfissao()) {
            profEgressoRepository.save(profissoes);
        }

        for (CursoEgresso cursos : egresso.getDatasCursos()) {
            cursoEgressoRepository.save(cursos);
        }

        return egressoSalvo;
    }

    @Transactional
    public void remover(Long egressoId) {
        Egresso egresso = egressoRepository.findById(egressoId)
                .orElseThrow(() -> new RegraNegocioException("Egresso não encontrado"));

        for (ProfEgresso profissoes : egresso.getProfissao()) {
            profEgressoRepository.delete(profissoes);
        }

        for (CursoEgresso cursos : egresso.getDatasCursos()) {
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

    private void verificarEgresso(Egresso egresso) {
        if (egresso == null) {
            throw new RegraNegocioException("Egresso inválido");
        }

        if ((egresso.getNome() == null) || egresso.getNome().equals(' ')) {
            throw new RegraNegocioException("O nome do egresso não está preenchido corretamente");
        }

        if ((egresso.getEmail() == null) || egresso.getEmail().equals(' ')) {
            throw new RegraNegocioException("O email do egresso não está preenchido corretamente");
        }

        if ((egresso.getCpf() == null) || egresso.getCpf().equals(' ')) {
            throw new RegraNegocioException("O cpf do egresso não está preenchido corretamente");
        }

        if ((egresso.getResumo() == null) || egresso.getResumo().equals(' ')) {
            throw new RegraNegocioException("O resumo do egresso não está preenchido corretamente");
        }

        if ((egresso.getUrlFoto() == null) || egresso.getUrlFoto().equals(' ')) {
            throw new RegraNegocioException("A url da foto do egresso não está preenchido corretamente");
        }
    }
}
