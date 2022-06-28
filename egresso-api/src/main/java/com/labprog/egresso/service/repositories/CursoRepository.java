package com.labprog.egresso.service.repositories;

import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.dto.CursoNumEgresso;
import com.labprog.egresso.model.entities.Curso;

import com.labprog.egresso.model.entities.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{

    @Query("select ce.curso.id " +
            "from CursoEgresso ce join ce.egresso e "+
            "where ce.egresso = :egresso ")
    List<Long> cursoPorEgresso(@Param("egresso") Egresso egresso);

    @Query("select new com.labprog.egresso.model.dto.CursoNumEgresso(ce.curso.id, count(ce.egresso))" +
            "from CursoEgresso ce " +
            "group by ce.curso.id")
    List<CursoNumEgresso> numEgressoPorCurso();
}
