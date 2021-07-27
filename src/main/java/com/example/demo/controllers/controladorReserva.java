package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Reserva;
import com.example.demo.services.reservaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reserva")
public class controladorReserva {
    @Autowired
    reservaServices reservaServices;

    @GetMapping()
    public ArrayList<Reserva> obtenerReserva() {
        return reservaServices.obtReserva();
    }

    @PostMapping()
    public Reserva guardarReserva(@RequestBody Reserva reserva) {
        return this.reservaServices.guardarReserva(reserva);
    }
    
    @GetMapping(path ="/{id}")
    public Optional<Reserva> obtenerReservaPorId(@PathVariable("id") Long  id) {
        return this.reservaServices.obtenerId(id);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.reservaServices.EliminarReserva(id);
        if (ok) {
            return "Se elimino la Reserva con el id " +id;
        } else {
            return "No se pudo eliminar la Reserva con el id " +id;
        }
    }
}
