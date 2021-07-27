package com.example.demo.repositories;




import java.util.List;

import com.example.demo.models.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface repositoriesCliente extends JpaRepository<Cliente,Long>{
    
    List<Cliente> findBydocumento(String documento); //Lista para buscar por el documento 

}