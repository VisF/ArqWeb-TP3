package main.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.repositories.CarreraRepository;
import main.dto.CarreraDTO;
import main.dto.CarreraInscriptosDTO;
import main.dto.CarreraReporteDTO;
import main.modelo.Carrera;


@Service
public class CarreraService {
	
	@Autowired
	private final CarreraRepository carreraRepository;
	
	public CarreraService(CarreraRepository carreraRepository) {
		 this.carreraRepository = carreraRepository;
	}
	
	public Iterable<Carrera> findAll(){
		return carreraRepository.findAll();
	}
	
	public Iterable<CarreraDTO> todas(){
		return carreraRepository.todas();
	}
	
	public Iterable<CarreraInscriptosDTO> conInscriptosDescendiente(){
		return carreraRepository.conInscriptosDescendiente();
	}
	/*
	public Optional<Carrera> findById(Integer id){
		return carreraRepository.findById(id);
	}*/
	
	//ver!
	public Carrera update(CarreraDTO carreraDTOput, Integer id) {	
		CarreraDTO carreraDTO = findByIdCustom(id).get();
		Carrera carreraAnt = new Carrera(carreraDTO);
		carreraAnt.setNombre(carreraDTOput.getNombre());
		return carreraRepository.save(carreraAnt);
	}
	

	public void delete(Integer id) {
		carreraRepository.deleteById(id);
	}

	public Carrera save(CarreraDTO carreraDTO) {
		Optional<Carrera> carreraExistente = carreraRepository.findByNombre(carreraDTO.getNombre());

        if (carreraExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una carrera con el nombre: " + carreraDTO.getNombre());
        }

        // Si no existe, la crea
        return carreraRepository.save(new Carrera(carreraDTO));
	}

	public Iterable<CarreraReporteDTO> reporteCarreras() {
		return carreraRepository.reporteCarreras();
	}
	
	public Optional<CarreraDTO> findByIdCustom(Integer id){
		return carreraRepository.findByIdCustom(id);
	}
}













