package com.example.demo.services;


import java.util.ArrayList;
import java.util.Optional;


import com.example.demo.models.Origen;
import com.example.demo.repositories.repositoriesOrigen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class origenServices {
    @Autowired
    repositoriesOrigen origenRepositori;

    //Ver todos los Origen
    public ArrayList<Origen> obtOrigen(){
        return (ArrayList<Origen>) origenRepositori.findAll();

    }

    //Guardar Origen
    public Origen guardarOrigen(Origen origen){
        return origenRepositori.save(origen);
    }

     //Buscar por ID Origen
     public Optional<Origen> obtenerId(Long id){
         return origenRepositori.findById(id);
     }

     //Eliminar Origen
     public boolean EliminarOrigen(Long id){
        try {
            origenRepositori.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
     } 
}
