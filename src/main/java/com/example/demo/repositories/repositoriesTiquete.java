package com.example.demo.repositories;

import com.example.demo.models.Tiquete;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoriesTiquete extends CrudRepository<Tiquete,Long> {
    
}
