package main.dto;

import java.io.Serializable;

public class CarreraDTO implements Serializable{

	private String nombre;

	public CarreraDTO(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
