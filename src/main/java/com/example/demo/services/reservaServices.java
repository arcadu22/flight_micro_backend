package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.Reserva;
import com.example.demo.repositories.repositoriesReserva;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reservaServices {
    @Autowired
    repositoriesReserva reservaRepositori;

    //Ver todos los usuarios
    public ArrayList<Reserva> obtReserva(){
        return (ArrayList<Reserva>) reservaRepositori.findAll();
    }
    //Guardar reserva
    public Reserva guardarReserva(Reserva reserva){
        return reservaRepositori.save(reserva);
    }
    //Buscar por ID reserva
    public Optional<Reserva>obtenerId(Long id){
        return reservaRepositori.findById(id);
    }
    //Eliminar
    public boolean EliminarReserva(Long id){
        try {
            reservaRepositori.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
