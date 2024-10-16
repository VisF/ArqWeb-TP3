package main.services;

import java.time.LocalDate;
import java.util.Optional;

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
	
	@Autowired
	private final EstudianteService estudianteService;
	
	@Autowired
	private final CarreraService carreraService;
	
	public EstudianteCarreraService(EstudianteCarreraRepository estudianteCarreraRepository,EstudianteService estudianteService,
			CarreraService carreraService) {
		this.estudianteCarreraRepository = estudianteCarreraRepository;
		this.estudianteService = estudianteService;
		this.carreraService = carreraService;
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

	public EstudianteCarrera saveEC(EstudianteCarreraPostDTO ecDTO) {
		//return estudianteCarreraRepository.saveEC(ec.getEstudianteId(),ec.getCarreraId(),ec.getFechaInicio(),ec.getFechaFin());
		Estudiante estudiante =  estudianteService.findById(ecDTO.getEstudianteId()).orElseThrow();
		Carrera carrera =  carreraService.findById(ecDTO.getCarreraId()).orElseThrow();
		
		EstudianteCarrera ec = new EstudianteCarrera(estudiante,carrera,ecDTO.getFechaInicio(),ecDTO.getFechaFin());
		return estudianteCarreraRepository.save(ec);

	}
	
	
	
	
}
