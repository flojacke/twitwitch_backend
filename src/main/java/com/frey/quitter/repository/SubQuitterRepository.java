package com.frey.quitter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frey.quitter.model.SubQuitter;

import java.util.Optional;

@Repository
public interface SubQuitterRepository extends JpaRepository<SubQuitter, Long> {

    Optional<SubQuitter> findByName(String subQuitterName);
}
