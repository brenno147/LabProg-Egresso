package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.ProfEgresso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfEgressoRepositorie extends JpaRepository<ProfEgresso, Long> {
}
