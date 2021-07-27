package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Avion")
public class Avion {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)

    // atributos
	private Long idAvion;

    @Column(length = 50, nullable = false)
	private String topoAvion;

	@Column(length = 4, nullable = false)
	private int capacidad;

	@Column(length = 11, nullable = false)
	private String matricula;

	@Column(length = 30, nullable = false)
	private String empresa;

	@Column(length = 30, nullable = false)
	private String ref;
	//constructor

	public Avion() {

	}
		
	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	//atributos
	public Long getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Long idAvion) {
		this.idAvion = idAvion;
	}

	public String getTopoAvion() {
		return topoAvion;
	}

	public void setTopoAvion(String topoAvion) {
		this.topoAvion = topoAvion;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
    
    public Avion(Long idAvion){
        this.idAvion = idAvion;
    }
	
	//Relacion de Con la tabla Tiquete
	@OneToMany(mappedBy = "avion")
	private Set<Tiquete> tiqueteList;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
	
    
	@ManyToOne
	@JoinColumn(name = "cliente")
	Cliente cliente;

    public Avion(Cliente cliente) {
        this.cliente = cliente;
    }
}

