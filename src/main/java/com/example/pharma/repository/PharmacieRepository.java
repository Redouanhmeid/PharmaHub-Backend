package com.example.pharma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pharma.model.Pharmacie;

@Repository
public interface PharmacieRepository extends JpaRepository<Pharmacie, Long>{

}
