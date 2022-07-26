package com.labprog.egresso.service;

import com.labprog.egresso.model.dto.CursoNumEgresso;
import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.entities.CursoEgresso;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.CursoEgressoRepository;
import com.labprog.egresso.model.repositories.CursoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoEgressoRepository curEgreRep;

    @Autowired
    private EgressoService egressoService;

    public Curso salvar(Curso curso) {
        verificarCurso(curso);
        return cursoRepository.save(curso);
    }

    public void remover(Long cursoId) {
        verificarId(cursoId);
        cursoRepository.deleteById(cursoId);
    }

    // consultar egressos por curso
    public List<Curso> consultarCursoPorEgresso(Long id) {
        Egresso egresso = egressoService.findById(id);
        List<Long> curso_ids = cursoRepository.cursoPorEgresso(egresso);
        List<Curso> cursos = cursoRepository.findAllById(curso_ids);
        return cursos;
    }

    // quantitativo de egressos por curso
    public List<CursoNumEgresso> quantEgressoPorCurso() {
        List<CursoNumEgresso> quantEgressosCurso = cursoRepository.numEgressoPorCurso();
        return quantEgressosCurso;
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
    }

    private void verificarId(Long cursoId) {
        if (cursoId == null) {
            throw new RegraNegocioException("Posicao sem id");
        }
    }

    private void verificarCurso(Curso curso) {
        if (curso == null)
            throw new RegraNegocioException("O curso é inválido");
        if ((curso.getNome() == null) || (curso.getNome().equals(' ')))
            throw new RegraNegocioException("O nome do curso não está preenchido corretamente");
        if ((curso.getNivel() == null) || (curso.getNivel().equals(' ')))
            throw new RegraNegocioException("O nível do curso não está preenchida corretamente");
    }


    public void deletar(CursoEgresso id){
        curEgreRep.delete(id);
    }

}
