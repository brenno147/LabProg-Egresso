package com.labprog.egresso.model.repositories;

import com.labprog.egresso.model.entities.Egresso;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EgressoRepository extends JpaRepository<Egresso, Long> {

    Egresso findByNome(String nome);

    Optional<Egresso> findByEmail(String email);
}
