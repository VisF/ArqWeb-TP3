package main.repositories;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.dto.EstudianteCarreraPostDTO;
import main.modelo.Carrera;
import main.modelo.Estudiante;
import main.modelo.EstudianteCarrera;
import main.modelo.EstudianteCarreraId;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, EstudianteCarreraId> {
	
	@Query("INSERT INTO EstudianteCarrera (estudianteId, carreraId, fechaInicio,fechaFin) "
			+ "VALUES (:estudianteId, :carreraId, :fechaInicio, :fechaFin)")
	EstudianteCarrera saveEC(Estudiante estudiante, Carrera carrera, LocalDate fechaInicio, LocalDate fechaFin);


}
