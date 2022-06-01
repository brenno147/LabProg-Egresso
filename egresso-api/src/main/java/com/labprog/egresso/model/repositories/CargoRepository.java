package com.labprog.egresso.model.repositories;


import java.util.List;


import com.labprog.egresso.model.entities.Cargo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{
    @Query("select count(pe.egresso) " +
        "from ProfEgresso pe join pe.cargo pec " +
        "where pe.cargo = :cargo")
    Integer quantEgressoCargo(@Param("cargo") Cargo cargo);

    @Query("select p.egresso.id " +
    "from ProfEgresso p join p.cargo c "+
    "where p.cargo = :cargo ")
    List<Long> cargoEgresso(@Param("cargo") Cargo cargo);


}
