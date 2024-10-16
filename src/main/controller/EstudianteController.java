package main.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.services.EstudianteService;
import main.dto.EstudianteDTO;
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
	
	//2.a
	@PostMapping("/")
    public Estudiante save(@RequestBody Estudiante estudiante){
        return service.save(estudiante);
    }
    
	//2.d
	@GetMapping("/libreta/{nro}")
	public Optional<Estudiante> getByLibreta(@PathVariable int nro){
		return service.findByLibreta(nro);
	}
	
	//2.e
	@GetMapping("/genero/{genero}")
	public Iterable<Estudiante> getByGenero(@PathVariable Character genero){
		return service.findByGenero(genero);
	}
	
	//2.c
	@GetMapping("/ordenadoCiudad")
	public Iterable<EstudianteDTO> getOrdenadoCiudad(){
		return service.getOrdenadoCiudad();
	}
	//2.g
	@GetMapping("/{carrera}/{ciudad}")
	public Iterable<EstudianteDTO> getEstudiantesDeCarreraPorCiudad(@PathVariable String ciudad,@PathVariable String carrera){
		return service.getEstudiantesDeCarreraPorCiudad(ciudad,carrera);
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Estudiante> update(@PathVariable Integer id, @RequestBody Estudiante estudiante) {
	        Optional<Estudiante> optionalEstudiante = service.findById(id);
	        //TODO mover a servicio
	        if (optionalEstudiante.isPresent()) {
	            Estudiante actualizado = service.update(id, estudiante);
	            return new ResponseEntity<>(actualizado, HttpStatus.OK);
	        } else {
	            // Si no encuentra el estudiante, devuelve un 404
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 
	 @DeleteMapping("/{id}")
		public void DeleteById(@PathVariable Integer id){
			service.delete(id);
		}
	
}
