package com.labprog.egresso.service.repositories;

import com.labprog.egresso.model.entities.Egresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EgressoRepository extends JpaRepository<Egresso, Long> {

    Egresso findByNome(String nome);
}
