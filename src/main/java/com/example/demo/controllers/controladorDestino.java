package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Destino;
import com.example.demo.services.destinoServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/destino")
public class controladorDestino {
    @Autowired
    destinoServices destinoServices;

    @GetMapping()
    public ArrayList<Destino> obtenterOrigen(){
        return this.destinoServices.obtDestino();
    }

    @PostMapping()
    public Destino guardarOrigen(@RequestBody Destino destino){
        return this.destinoServices.guardarDestino(destino);
    }

    @GetMapping(path = "/{id}")
    public Optional<Destino> obtenerDestinoPorId(@PathVariable("id") Long id){
        return this.destinoServices.obtenerId(id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.destinoServices.EliminarDestino(id);
        if (ok) {
            return "Se elimino el Destino con el id ";
        } else {
            return "No se pudo eliminar el Destino con el id";
        }
    }
}
