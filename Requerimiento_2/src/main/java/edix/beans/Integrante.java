package edix.beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="integrante")
@XmlType(propOrder= {
		"nombre",
		"edad",
		"rol"
})
public class Integrante {
	
	private String nombre;
	private int edad;
	private String rol;
	
	public Integrante() {
		
	}

	public Integrante(String nombre, int edad, String rol) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Integrante [nombre=" + nombre + ", edad=" + edad + ", rol=" + rol + "]";
	}
	
	

}
