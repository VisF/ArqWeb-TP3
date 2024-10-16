package main.modelo;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import main.dto.CarreraDTO;

@Entity
public class Carrera {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column    
	private String nombre;
	
	@OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL)
	private List<EstudianteCarrera> estudiantes;
	
	public Carrera() {
		super();
	}
	
	public Carrera(String nombre) {
		this.nombre = nombre;
	}
	
	public Carrera(CarreraDTO dto) {
		this.nombre=dto.getNombre();
		this.id=dto.getId();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<EstudianteCarrera> getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(List<EstudianteCarrera> estudiantes) {
		this.estudiantes = estudiantes;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", nombre=" + nombre + "]";
	}
}
