package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Destino;
import com.example.demo.repositories.repositoriesDestino;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class destinoServices {
    @Autowired
    repositoriesDestino destinoRepositori;

    //Ver todos los Destino
    public ArrayList<Destino> obtDestino(){
        return (ArrayList<Destino>) destinoRepositori.findAll();

    }

     //Guardar Destino
     public Destino guardarDestino(Destino destino){
        return destinoRepositori.save(destino);
    }

      //Buscar por ID Destino
      public Optional<Destino> obtenerId(Long id){
        return destinoRepositori.findById(id);
    }

     //Eliminar Destino
     public boolean EliminarDestino(Long id){
        try {
            destinoRepositori.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
     } 
}
