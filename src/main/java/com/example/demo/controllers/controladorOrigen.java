package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Origen;
import com.example.demo.services.origenServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/origen")
public class controladorOrigen {
    @Autowired
    origenServices origenServices;

    @GetMapping()
    public ArrayList<Origen> obtenterOrigen(){
        return this.origenServices.obtOrigen();
    }

    @PostMapping()
    public Origen guardarOrigen(@RequestBody Origen origen){
        return this.origenServices.guardarOrigen(origen);
    }

    @GetMapping(path = "/{id}")
    public Optional<Origen> obtenerOrigenPorId(@PathVariable("id") Long id){
        return this.origenServices.obtenerId(id);
    
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.origenServices.EliminarOrigen(id);
        if (ok) {
            return "Se elimino el Origen con el id ";
        } else {
            return "No se pudo eliminar el Origen con el id";
        }
    }
}
