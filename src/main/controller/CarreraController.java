package main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.services.CarreraService;
import main.dto.CarreraDTO;
import main.dto.CarreraInscriptosDTO;
import main.modelo.Carrera;

@RestController
@RequestMapping("carreras")
public class CarreraController {

	@Autowired
	private final CarreraService service;
	
	public CarreraController(CarreraService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public Iterable<CarreraDTO> todas(){
		return service.todas();
	}
	
	@GetMapping("/reporte")
	public Iterable<CarreraInscriptosDTO> conInscriptosDescendiente(){
		return service.conInscriptosDescendiente();
	}
	@GetMapping("/{id}")
	public Optional<Carrera> getById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping("/")
    public Carrera save(@RequestBody Carrera carrera){
        return service.save(carrera);
    }
	
	@PutMapping("/{id}")
	public Carrera update(@RequestBody Carrera carrera, @PathVariable Integer id) {
		return service.update(carrera, id);
	}
}








