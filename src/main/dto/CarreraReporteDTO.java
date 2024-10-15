package main.dto;

import java.io.Serializable;


public class CarreraReporteDTO implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreCarrera;
    private int anio;
    private Long cantidadInscriptos;
    private long cantidadEgresados;

    
    public CarreraReporteDTO(String nombreCarrera, int anio, Long insc, long egres) {
    	this.nombreCarrera = nombreCarrera;
    	this.anio = anio;
    	this.cantidadEgresados = egres;
    	this.cantidadInscriptos = insc;
    }

    public String getNombreCarrera() {
    	
        return nombreCarrera;
    }

    public int getAnio() {
        return anio;
    }

    public long getCantidadInscriptos() {
        return cantidadInscriptos;
    }

    public long getCantidadEgresados() {
        return cantidadEgresados;
    }

	@Override
	public String toString() {
		return "CarreraReporteDTO [nombreCarrera=" + nombreCarrera + ", anio=" + anio + ", cantidadInscriptos="
				+ cantidadInscriptos + ", cantidadEgresados=" + cantidadEgresados + "]";
	}
    
    
}

