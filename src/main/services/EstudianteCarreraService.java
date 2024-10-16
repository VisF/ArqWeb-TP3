package main.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.dto.EstudianteCarreraPostDTO;
import main.modelo.Carrera;
import main.modelo.Estudiante;
import main.modelo.EstudianteCarrera;
import main.repositories.EstudianteCarreraRepository;

@Service
public class EstudianteCarreraService {

	@Autowired
	private final EstudianteCarreraRepository estudianteCarreraRepository;
	
	public EstudianteCarreraService(EstudianteCarreraRepository estudianteCarreraRepository) {
		this.estudianteCarreraRepository = estudianteCarreraRepository;
	}
	
	public Iterable<EstudianteCarrera> findAll(){
		return estudianteCarreraRepository.findAll();
	}
	
	public EstudianteCarrera save(Estudiante estudiante, Carrera carrera) {
		//ver q le pasen la fecha! lo ago asi para probar
		EstudianteCarrera nuevo = new EstudianteCarrera(estudiante, carrera, LocalDate.now());
		estudianteCarreraRepository.save(nuevo);
		return nuevo;
	}

	public EstudianteCarrera saveEC(EstudianteCarreraPostDTO ec) {
		return estudianteCarreraRepository.saveEC(ec.getEstudianteId(),ec.getCarreraId(),ec.getFechaInicio(),ec.getFechaFin());
	}
	
	
	
	
}
