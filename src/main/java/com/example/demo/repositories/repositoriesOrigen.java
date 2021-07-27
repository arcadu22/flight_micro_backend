package com.example.demo.repositories;

import com.example.demo.models.Origen;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface repositoriesOrigen extends CrudRepository<Origen,Long> {
    
}
