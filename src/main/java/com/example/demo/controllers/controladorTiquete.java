package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Tiquete;
import com.example.demo.services.tiqueteServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tiquete")
public class controladorTiquete {
    @Autowired
    tiqueteServices tiqueteServices;

    @GetMapping()
    public ArrayList<Tiquete> obtenterTiquete(){
        return this.tiqueteServices.obtTiquete();
    }

    @PostMapping()
    public Tiquete guardarTiquete(@RequestBody Tiquete tiquete){
        return this.tiqueteServices.guardarTiquete(tiquete);
    }

    
    @GetMapping(path = "/{id}")
    public Optional<Tiquete> obtenerTiquetePorId(@PathVariable("id") Long id){
        return this.tiqueteServices.obtenerId(id);
    
    }

    @DeleteMapping(path =  "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.tiqueteServices.EliminarTiquete(id);
        if (ok) {
            return "Se elimino el tiquete con el id "+ id;
        } else {
            return "No se pudo eliminar el tiquete con el id"+ id;
        }
    }
}
