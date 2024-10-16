package main.utils;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import main.modelo.Carrera;
import main.modelo.EstudianteCarrera;
import main.repositories.CarreraRepository;
import main.repositories.EstudianteCarreraRepository;

import main.modelo.Estudiante;
import main.repositories.EstudianteRepository;



@Configuration

class LoadDatabase {

	    @Bean
	    CommandLineRunner initDatabase(EstudianteRepository estudianteRepository, CarreraRepository carreraRepo, EstudianteCarreraRepository estCarreraRepo) {
	        return args -> {
	        	
	        	 /*var student1 = new Estudiante("Student1", "ApStudent1", LocalDate.now() , 'M' , 123458, "Tres Arroyos");
		            var student2 = new Estudiante("Student2", "ApStudent2", LocalDate.now() , 'M' , 123489, "Tres Arroyos", 9);
		            var student3 = new Estudiante("Student3", "ApStudent3", LocalDate.now() , 'M' , 123481, "Tres Arroyos", 7);
		            
		            var carrera1 = new Carrera("TUDAI");
		            var carrera2 = new Carrera("Filosofia");
		            var carrera3 = new Carrera("Contador publico");
		            
		            var relacion1 = new EstudianteCarrera(student1, carrera1, LocalDate.now());
		            var relacion2 = new EstudianteCarrera(student2, carrera1, LocalDate.now());
		            var relacion3 = new EstudianteCarrera(student3, carrera2, LocalDate.now());
		            var relacion4 = new EstudianteCarrera(student1, carrera3, LocalDate.now());
		            
		            try {
		            	estudianteRepository.save(student1);
		            	estudianteRepository.save(student2);
		            	estudianteRepository.save(student3);
		            	
		            	carreraRepo.save(carrera1);
		            	carreraRepo.save(carrera2);
		            	carreraRepo.save(carrera3);
		            	
		            	//me trae cualq cosa!
		            	estCarreraRepo.save(relacion1);
		            	estCarreraRepo.save(relacion2);
		            	estCarreraRepo.save(relacion3);
		            	estCarreraRepo.save(relacion4);
		            	
		            }catch (Exception e) {
		            	
		            }
		            */
		            try {
		            	Estudiante es = new Estudiante("Paula" , "Sabatini", LocalDate.now() , 'F', 2345, "Chacabuco", 1);
		        		Estudiante es2 = new Estudiante("Laura" , "Martinez", LocalDate.now() , 'F', 2345, "Zamora", 2);
		        		Estudiante es3 = new Estudiante("Anastacia" , "Lopez", LocalDate.now() , 'F', 2345, "Loberia",  3);
		        		Estudiante es4 = new Estudiante("Juan" , "Lopez", LocalDate.now() , 'M', 2345, "Loberia",  4);
		        		Estudiante es5 = new Estudiante("Pedro" , "Lopez", LocalDate.now() , 'M', 2345, "Loberia",  5);
		        		Estudiante es6 = new Estudiante("Laura" , "Garcia", LocalDate.now() , 'F', 2345, "Zamora",  6);
		        		
		        		
		        		estudianteRepository.save(es);
		        		estudianteRepository.save(es2);
		        		estudianteRepository.save(es3);
		        		estudianteRepository.save(es4);
		        		estudianteRepository.save(es5);
		        		estudianteRepository.save(es6);
		        		
		        		
		        		/*CARRERAS*/
		        		
		        		Carrera c1 = new Carrera("TUDAI");
		        		Carrera c2 = new Carrera("Tecnicatura en Bioingenieria");
		        		
		        		carreraRepo.save(c1);
		        		carreraRepo.save(c2);
		        		
		        		
		        		/*ESTUDIANTE - CARRERA*/
		        		EstudianteCarrera ec = new EstudianteCarrera(es, c1,  LocalDate.now());
		        		EstudianteCarrera ec2 = new EstudianteCarrera(es2, c1,  LocalDate.now().minusYears(10));
		        		EstudianteCarrera ec3 = new EstudianteCarrera(es3, c1,  LocalDate.now().minusMonths(4));
		        		EstudianteCarrera ec4 = new EstudianteCarrera(es4, c2,  LocalDate.now());
		        		EstudianteCarrera ec5 = new EstudianteCarrera(es5, c2,  LocalDate.now());
		        		
		        		estCarreraRepo.save(ec);
		        		estCarreraRepo.save(ec2);
		        		estCarreraRepo.save(ec3);
		        		estCarreraRepo.save(ec4);
		        		estCarreraRepo.save(ec5);
		            }catch(Exception e) {
		            	
		            }
	        };
	    }
}
