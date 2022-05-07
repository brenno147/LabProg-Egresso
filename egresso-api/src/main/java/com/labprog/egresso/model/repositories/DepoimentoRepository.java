package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.Depoimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
}
