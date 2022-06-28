package com.labprog.egresso.service;

import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.dto.CursoNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Curso;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.repositories.CursoRepository;
import com.labprog.egresso.service.exceptions.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EgressoService egressoService;

    public Curso salvar(Curso curso) {
        return cursoRepository.save(curso);
    }

    public void remover(Long cursoId) {
        cursoRepository.deleteById(cursoId);
    }

    // consultar egressos por curso
    public List<Curso> consultarCursoPorEgresso(Long id){
        Egresso egresso = egressoService.findById(id);
        List<Long> curso_ids = cursoRepository.cursoPorEgresso(egresso);
        List<Curso> cursos = cursoRepository.findAllById(curso_ids);
        return cursos;
    }


    //quantitativo de egressos por curso
    public List<CursoNumEgresso> quantEgressoPorCurso(){
        List<CursoNumEgresso> quantEgressosCurso = cursoRepository.numEgressoPorCurso();
        return quantEgressosCurso;
    }

    public Curso buscarPorId(Long id) {
        return cursoRepository.findById(id).orElseThrow(() -> new RegraNegocioException("Curso não encontrado"));
    }
}
