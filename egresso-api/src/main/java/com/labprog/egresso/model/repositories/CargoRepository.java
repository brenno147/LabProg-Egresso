package com.labprog.egresso.model.repositories;


import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;
import com.labprog.egresso.model.entities.ProfEgresso;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
    @Query("select p.cargo.id " +
        "from ProfEgresso p join p.egresso e "+
        "where p.egresso = :egresso ")
    List<Long> cargoPorEgresso(@Param("egresso") Egresso egresso);

    @Query("select new com.labprog.egresso.model.dto.CargoNumEgresso(p.cargo.id, count(p.egresso))" +
        "from ProfEgresso p " +
        "group by p.cargo.id")
    List<CargoNumEgresso> numEgressoPorCargo();
    
}
