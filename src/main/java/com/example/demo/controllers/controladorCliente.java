package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.models.Cliente;
import com.example.demo.services.clienteServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuario")
public class controladorCliente {
    @Autowired
    clienteServices clienteServices;

    @GetMapping()
    public ArrayList<Cliente> obtenerUsuario() {
        return clienteServices.obtClientes();
    }

   @GetMapping("/query")
    public List<Cliente> actualizar(@RequestParam("documento") String documento){
        if(documento.equals("")){
            return this.obtenerUsuario();
        }            
        else{
            return this.clienteServices.obtIdentificacion(documento);
        }
    } 
   
    @PostMapping()
    public Cliente guardarUsuario(@RequestBody Cliente cliente) {
        return this.clienteServices.guardarCliente(cliente);
    }
    
    @PutMapping(path = "/{id}")
    public Cliente actuaCliente(@RequestBody Cliente cliente, @PathVariable ("id") Long id){
        return this.clienteServices.actualizar(cliente, id);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.clienteServices.EliminarCliente(id);
        if (ok) {
            return "Se elimino el Usuario con el id "+id;
        } else {
            return "No se pudo eliminar el usuario con el id"+id;
        }
    }
}
