package edix.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="cancion")
public class Cancion {
	private String nombre;
	private String duracion;
	
	public Cancion() {
		
	}

	public Cancion(String nombre, String duracion) {
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Cancion [nombre=" + nombre + ", duracion=" + duracion + "]";
	}
	
	
	
	

}
