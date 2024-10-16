package main.modelo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@IdClass(EstudianteCarreraId.class)
public class EstudianteCarrera {


	@Id
	@ManyToOne
	@JoinColumn(name = "idestudiante", nullable = false)
	@JsonBackReference
	private Estudiante estudiante;
	@Id
	@ManyToOne
	@JoinColumn(name = "idcarrera", nullable = false)
	@JsonBackReference
	private Carrera carrera;
	@Column
	private LocalDate fechaInicio;
	@Column
	private LocalDate fechaFin;
	
	public EstudianteCarrera() {
		
	}

	public EstudianteCarrera(Estudiante estudiante, Carrera carrera, LocalDate fechainicio) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.fechaInicio = fechainicio;
		this.fechaFin = null;
	}
	
	public EstudianteCarrera(Estudiante estudiante, Carrera carrera, LocalDate fechainicio, LocalDate fechaFin) {
		this(estudiante,carrera,fechainicio);
		this.fechaFin=fechaFin;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Carrera getCarrera() {
		return carrera;
	}
	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}
	public LocalDate getFechainicio() {
		return fechaInicio;
	}
	public void setFechainicio(LocalDate fechainicio) {
		this.fechaInicio = fechainicio;
	}
	public LocalDate getFechafin() {
		return fechaFin;
	}
	public void setFechafin(LocalDate fechafin) {
		this.fechaFin = fechafin;
	}
	
}
