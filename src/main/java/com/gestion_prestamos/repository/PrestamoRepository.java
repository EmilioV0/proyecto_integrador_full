package com.gestion_prestamos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion_prestamos.entity.prestamos;

@Repository
public interface PrestamoRepository extends JpaRepository<prestamos, Integer> {

}
