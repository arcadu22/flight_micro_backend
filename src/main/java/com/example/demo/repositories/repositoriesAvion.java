package com.example.demo.repositories;

import java.util.List;

import com.example.demo.models.Avion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoriesAvion extends JpaRepository<Avion,Long> {
    List <Avion> findByref(String ref);
}
