package main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import main.dto.CarreraReporteDTO;
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
	
	//2.f
	@GetMapping("/ordenadasInscriptos")
	public Iterable<CarreraInscriptosDTO> conInscriptosDescendiente(){
		return service.conInscriptosDescendiente();
	}
	@GetMapping("/{id}")
	public Optional<Carrera> getById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping("/")
    public ResponseEntity<Carrera> save(@RequestBody Carrera carrera) {
        Carrera nuevaCarrera = service.save(carrera);
        return ResponseEntity.ok(nuevaCarrera);
    }
	
	@PutMapping("/{id}")
	public Carrera update(@RequestBody Carrera carrera, @PathVariable Integer id) {
		return service.update(carrera, id);
	}
	
	@GetMapping("/reporte")
	public Iterable<CarreraReporteDTO> reporteCarreras(){
		return service.reporteCarreras();
	}
	
	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		service.delete(id);
	}
}








