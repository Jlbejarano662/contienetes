package com.alkemy.continentes.continentes.repository;

import com.alkemy.continentes.continentes.entity.ContinenteEntity;
import com.alkemy.continentes.continentes.entity.IconEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IconRepository  extends JpaRepository<IconEntity, Long>, JpaSpecificationExecutor<IconEntity> {

    List<IconEntity> findAll(Specification<IconEntity> esp);

}
