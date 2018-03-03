package com.sistema.cervejaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sistema.cervejaria.model.Estado;

//repositório estado
@Repository
public interface Estados extends JpaRepository<Estado, Long>{

}
