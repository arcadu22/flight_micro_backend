package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Avion;
import com.example.demo.repositories.repositoriesAvion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class avionServices {
    @Autowired
    repositoriesAvion avionRepositori;

//Ver todos los Aviones
public ArrayList<Avion> obtAvion(){
    return (ArrayList<Avion>) avionRepositori.findAll();
}

    
  //Guardar Avion
  public Avion guardarAvion(Avion avion){
    return avionRepositori.save(avion);
}

//Buscar por ID Avion
public Optional<Avion>obtenerId(Long id){
    return avionRepositori.findById(id);
}

  //Eliminar Avion
  public boolean EliminarAvion(Long id){
    try {
        avionRepositori.deleteById(id);
        return true;
    } catch (Exception e) {
        return false;
    }
}

 public  List<Avion> busRef(String ref){
        return avionRepositori.findByref(ref);
    }
    

}
