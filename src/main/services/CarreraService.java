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

	public Optional<Carrera> findById(Integer id){
		return carreraRepository.findById(id);
	}
	
	//ver!
	public Carrera update(Carrera carrera, Integer id) {	
		Carrera carreraAnt = findById(id).get();
		carreraAnt.setNombre(carrera.getNombre());
		return carreraRepository.save(carreraAnt);
	}
	

	public void delete(Integer id) {
		carreraRepository.deleteById(id);
	}

	public Carrera save(Carrera carrera) {
		Optional<Carrera> carreraExistente = carreraRepository.findByNombre(carrera.getNombre());

        if (carreraExistente.isPresent()) {
            throw new IllegalArgumentException("Ya existe una carrera con el nombre: " + carrera.getNombre());
        }

        // Si no existe, la crea
        return carreraRepository.save(carrera);
	}

	public Iterable<CarreraReporteDTO> reporteCarreras() {
		return carreraRepository.reporteCarreras();
	}
	
}













