package main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.modelo.Estudiante;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	//Filtra estudiante por numero de libreta
	@Query("SELECT e FROM Estudiante e WHERE e.nroLibreta = :nro")
	Optional<Estudiante> findByLibreta(int nro);
	
	//Filtra estudiantes por genero
	@Query("SELECT e FROM Estudiante e WHERE e.genero = :genero")
	Iterable<Estudiante> findByGenero(Character genero);
}
