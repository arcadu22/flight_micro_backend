package com.example.demo.models;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)

	// atributos
	private Long idUsuario;

	@Column(length = 50, nullable = false)
	private String nombre;

	@Column(length = 50, nullable = false)
	private String apellido;

	@Column(length = 11, nullable = false)
	private int edad;

	@Column(length = 20, nullable = false)
	private String documento;

	
	@Column(length = 40, nullable = false)
	private String email;

	@Column(length = 40, nullable = false)
	private String telefono;

	// contructor
	public Cliente() {

	}

	public Cliente(String nombre, String apellido, int edad, String documento, String email, String telefono) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.documento = documento;
		this.email = email;
		this.telefono = telefono;
	}

	// Metodos Get y Set
	public Long getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDocumento() {
		return this.documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	// Bidireccionamiento
	public Cliente(Long idUsuario) {
		this.idUsuario = idUsuario;

	}

   //Relacion con la tabla Reserva
	@OneToMany(mappedBy = "cliente" )
	private Set<Reserva> reservaList ;

	//Relacion con la tabla Tiquete
	@OneToMany(mappedBy = "cliente")
	private Set<Tiquete> tiqueteList;

	@OneToMany(mappedBy = "cliente")
	private Set<Avion> avionList;

}
