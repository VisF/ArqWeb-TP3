package main.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.repositories.EstudianteRepository;
import main.dto.EstudianteDTO;
import main.modelo.Estudiante;

@Service
public class EstudianteService {
	
	@Autowired
	private final EstudianteRepository repository;
	
	public EstudianteService(EstudianteRepository repository) {
		 this.repository = repository;
	}
	
	public Iterable<Estudiante> findAll(){
		return repository.findAll();
	}
	
	public Optional<Estudiante> findById(Integer id){
		return repository.findById(id);
	}
	
	public Estudiante save(Estudiante estudiante) {
		Optional<Integer> maxLibreta = repository.findMaxNroLibreta();
		int nuevoNroLibreta = maxLibreta.orElse(0) + 1;
		
		estudiante.setNroLibreta(nuevoNroLibreta);
		repository.save(estudiante);
		return estudiante;
	}
	
	/*public Estudiante update(Estudiante estudiante) {	
	}
	*/
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
	public Optional<Estudiante> findByLibreta(int nro){
		return repository.findByLibreta(nro);
	}

	public Iterable<Estudiante> findByGenero(Character genero){
		return repository.findByGenero(genero);
	}

	public Iterable<EstudianteDTO> getOrdenadoCiudad() {
		return repository.getOrdenadoCiudad();
	}

	public Iterable<EstudianteDTO> getEstudiantesDeCarreraPorCiudad(String ciudad, String carrera) {
		// TODO Auto-generated method stub
		return repository.getEstudiantesDeCarreraPorCiudad(ciudad,carrera);
	}

	public Estudiante update(Integer id, Estudiante estudianteActualizado) {
        // Buscar el estudiante existente por ID
        Optional<Estudiante> optionalEstudiante = repository.findById(id);

        if (optionalEstudiante.isPresent()) {
            Estudiante estudianteExistente = optionalEstudiante.get();

            // Actualizar los campos con los nuevos valores
            estudianteExistente.setNombre(estudianteActualizado.getNombre());
            estudianteExistente.setApellido(estudianteActualizado.getApellido());
            estudianteExistente.setFechaNac(estudianteActualizado.fechaNac());
            estudianteExistente.setGenero(estudianteActualizado.getGenero());
            estudianteExistente.setDni(estudianteActualizado.getDni());
            estudianteExistente.setCiudadDeResidencia(estudianteActualizado.getCiudadDeResidencia());

            // Guardar el estudiante actualizado
            return repository.save(estudianteExistente);
        } else {
            throw new IllegalArgumentException("Estudiante con id " + id + " no encontrado.");
        }
    }

}
