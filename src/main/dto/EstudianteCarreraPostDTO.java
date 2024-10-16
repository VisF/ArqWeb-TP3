package main.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class EstudianteCarreraPostDTO implements Serializable{
	private Integer estudianteId;
	private Integer carreraId;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	
	
	public EstudianteCarreraPostDTO(Integer estudianteId, Integer carreraId, LocalDate fechaInicio,
			LocalDate fechaFin) {
		super();
		
		this.estudianteId = estudianteId;
		this.carreraId = carreraId;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public Integer getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(Integer estudianteId) {
		this.estudianteId = estudianteId;
	}
	public Integer getCarreraId() {
		return carreraId;
	}
	public void setCarreraId(Integer carreraId) {
		this.carreraId = carreraId;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
}
