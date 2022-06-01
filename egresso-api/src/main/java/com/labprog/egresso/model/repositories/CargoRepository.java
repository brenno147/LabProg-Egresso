package com.labprog.egresso.model.repositories;


import com.labprog.egresso.model.dto.CargoNumEgresso;
import com.labprog.egresso.model.entities.Cargo;
import com.labprog.egresso.model.entities.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
    @Query("select pe.cargo" +
            "from profEgressos pe" +
            "where pe.egresso = :egresso")
    public List<Cargo> cargoPorEgresso(@Param("egresso") Egresso egresso);

    @Query("select new com.labprog.egresso.model.dto.CargoNumEgresso(pe.cargo, count(pe.egresso))" +
            "from profEgressos pe" +
            "group by pe.cargo")
    public List<CargoNumEgresso> numEgressoPorCargo();

}
