package main.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import main.modelo.EstudianteCarrera;
import main.modelo.EstudianteCarreraId;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, EstudianteCarreraId> {


}
