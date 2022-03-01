package edix.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="grupo")
@XmlType(propOrder= {
		"nombre",
		"integrantes",
		"canciones"
})
public class Grupo {
	
	private String nombre;
	private List<Integrante> integrantes;
	private List<Cancion> canciones;
	
	public Grupo() {
		
	}

	public Grupo(String nombre, List<Integrante> integrantes, List<Cancion> canciones) {
		this.nombre = nombre;
		this.integrantes = integrantes;
		this.canciones = canciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@XmlElement(name="integrante")
	@XmlElementWrapper(name="integrantes")
	public List<Integrante> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(List<Integrante> integrantes) {
		this.integrantes = integrantes;
	}
	
	@XmlElement(name="cancion")
	@XmlElementWrapper(name="canciones")
	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	@Override
	public String toString() {
		return "Grupo [nombre=" + nombre + ", integrantes=" + integrantes + ", canciones=" + canciones + "]";
	}

	
	
}
