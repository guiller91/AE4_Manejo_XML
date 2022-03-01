package edix.beans;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="concierto")
@XmlType(propOrder= {
		"nombre",
		"hora",
		"grupo"
})
public class Concierto {
	
	private String nombre;
	private String hora;
	private Grupo grupo;
	
	public Concierto() {	
	}

	public Concierto(String nombre, String hora, Grupo grupo) {
		super();
		this.nombre = nombre;
		this.hora = hora;
		this.grupo = grupo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public String toString() {
		return "Concierto [nombre=" + nombre + ", hora=" + hora + ", grupo=" + grupo + "]";
	}
	
	

}
