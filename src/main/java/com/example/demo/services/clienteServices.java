package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Cliente;
import com.example.demo.repositories.repositoriesCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class clienteServices {
    @Autowired
    repositoriesCliente clienteRepositori;

    //Ver todos los usuarios
    public ArrayList<Cliente> obtClientes(){
        return (ArrayList<Cliente>) clienteRepositori.findAll();
    }
    //Guardar cliente
    public Cliente guardarCliente(Cliente cliente){
        return clienteRepositori.save(cliente);
    }

    //Buscar por identificacion
    public List<Cliente> obtIdentificacion(String documento){
        return clienteRepositori.findBydocumento(documento);
    }
    //Eliminar
    public boolean EliminarCliente(Long id){
        try {
            clienteRepositori.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    //Actualizar
    public Cliente actualizar(Cliente cliente,Long id) {
    
        Optional<Cliente> optional2 = clienteRepositori.findById(cliente.getIdUsuario());
        Cliente existCliente = optional2.get();
        existCliente.setEmail(cliente.getEmail());
        existCliente.setEdad(cliente.getEdad());
        existCliente.setNombre(cliente.getNombre());
        existCliente.setTelefono(cliente.getTelefono());
        existCliente.setApellido(cliente.getApellido());

        return clienteRepositori.save(existCliente);
    } 
}
