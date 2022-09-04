package com.alkemy.continentes.continentes.repository;


import com.alkemy.continentes.continentes.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaisRepository extends JpaRepository<PaisEntity, Long> {
}
