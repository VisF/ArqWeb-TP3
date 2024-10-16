package main.dto;

import java.io.Serializable;

public class CarreraDTO implements Serializable{

	private String nombre;
	private Integer id;

	public CarreraDTO(String nombre,Integer id) {
		this.nombre=nombre;
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
