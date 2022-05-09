package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.FaixaSalario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaixaSalarioRepository extends JpaRepository<FaixaSalario, Long> {
}
