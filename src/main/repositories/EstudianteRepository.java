package main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.dto.EstudianteDTO;
import main.modelo.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	//Filtra estudiante por numero de libreta
	@Query("SELECT e FROM Estudiante e WHERE e.nroLibreta = :nro")
	Optional<Estudiante> findByLibreta(int nro);
	
	//Filtra estudiantes por genero
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	Iterable<Estudiante> findByGenero(Character genero);

	@Query("SELECT new main.dto.EstudianteDTO(e.nombre,e.apellido,e.fechaNac,e.genero,e.dni,e.ciudadDeResidencia,e.nroLibreta) "
			+ "FROM Estudiante e "
			+ "ORDER BY e.ciudadDeResidencia")
	Iterable<EstudianteDTO> getOrdenadoCiudad();

	@Query("SELECT new main.dto.EstudianteDTO(e.nombre,e.apellido,e.fechaNac,e.genero,e.dni,e.ciudadDeResidencia,e.nroLibreta) "
			+ "FROM Estudiante e JOIN e.carreras ec "
			+ "JOIN ec.carrera c "
			+ "WHERE c.nombre = ?2 "
			+ " AND e.ciudadDeResidencia = ?1 ")
	Iterable<EstudianteDTO> getEstudiantesDeCarreraPorCiudad(String ciudad, String carrera);
	
	@Query("SELECT MAX(e.nroLibreta) FROM Estudiante e")
	Optional<Integer> findMaxNroLibreta();
}
