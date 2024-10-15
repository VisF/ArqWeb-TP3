package main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.services.EstudianteService;

import main.modelo.Estudiante;

@RestController
@RequestMapping("estudiantes")
public class EstudianteController {

	@Autowired
	private final EstudianteService service;
	
	public EstudianteController(EstudianteService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public Iterable<Estudiante> getAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Estudiante> getById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PostMapping("/")
    public Estudiante save(@RequestBody Estudiante estudiante){
        return service.save(estudiante);
    }
    
	@GetMapping("/libreta/{nro}")
	public Optional<Estudiante> getByLibreta(@PathVariable int nro){
		return service.findByLibreta(nro);
	}
	
	@GetMapping("/genero/{genero}")
	public Iterable<Estudiante> getByGenero(Character genero){
		return service.findByGenero(genero);
	}
	
}
