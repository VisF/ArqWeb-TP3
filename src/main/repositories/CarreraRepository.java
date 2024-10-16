package main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.dto.CarreraDTO;
import main.dto.CarreraInscriptosDTO;
import main.dto.CarreraReporteDTO;
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

	@Query("SELECT c FROM Carrera c WHERE LOWER(c.nombre) = LOWER(:nombre)")
    Optional<Carrera> findByNombre(String nombre);
	
	@Query("SELECT new main.dto.CarreraDTO(c.nombre) FROM Carrera c WHERE c.id=:id")
    Optional<Carrera> findById(Integer id);
	
	@Query("SELECT new main.dto.CarreraReporteDTO(c.nombre, YEAR(ec.fechaInicio), " +
	        "COUNT(ec), " +
	        "(SELECT COUNT(ece) FROM EstudianteCarrera ece WHERE ece.carrera.id = c.id AND YEAR(ece.fechaFin) = YEAR(ec.fechaInicio))) " +
	        "FROM Carrera c JOIN c.estudiantes ec " +
	        "GROUP BY c.nombre, YEAR(ec.fechaInicio) " +
	        "ORDER BY c.nombre ASC, YEAR(ec.fechaInicio) ASC")
	Iterable<CarreraReporteDTO> reporteCarreras();
}
