package main.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.dto.CarreraDTO;
import main.dto.CarreraInscriptosDTO;
import main.modelo.Carrera;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

	@Query("SELECT new main.dto.CarreraDTO(c.nombre) FROM Carrera c")
	Iterable<CarreraDTO> todas();
	
	@Query("SELECT new main.dto.CarreraInscriptosDTO(c.nombre, COUNT(ec.carrera))"
			+ "				FROM Carrera c JOIN c.estudiantes ec "
			+ "				GROUP BY c.id "
			+ "				ORDER BY COUNT(ec.carrera) DESC ")
	Iterable<CarreraInscriptosDTO> conInscriptosDescendiente();
}
