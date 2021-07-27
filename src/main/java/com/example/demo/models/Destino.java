package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Destino")
public class Destino {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)

    // atributos
	private Long idDestino;

    @Column(length = 40, nullable = false)
	private String aeropuerto;

	@Column(length = 40, nullable = false)
	private String ciudad;

    @Column(length = 40, nullable = false)
	private String pais;

    public Destino() {
    }

        //Metodos Get Y Set
        
    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(String aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
     
    public Destino(Long idDestino){
        this.idDestino = idDestino;
    }

    //Relacion con la tabla Tiquete 
    @OneToMany(mappedBy = "destino")
	private Set<Tiquete> tiqueteList;
}
