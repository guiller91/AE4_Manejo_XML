package edix.beans;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="festival")
@XmlType(propOrder = {
		"nombre",
		"fecha",
		"hora",
		"direccion",
		"conciertos"
})
public class Festival {
	
	private String nombre;
	private String fecha;
	private String hora;
	private Direccion direccion;
	private List<Concierto> conciertos;
	
	public Festival() {		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	public String getHora() {
		return hora;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@XmlElement(name="concierto")
	@XmlElementWrapper(name="conciertos")
	public List<Concierto> getConciertos() {
		return conciertos;
	}

	public void setConciertos(List<Concierto> conciertos) {
		this.conciertos = conciertos;
	}

	@Override
	public String toString() {
		return "Festival [nombre=" + nombre + ", fecha=" + fecha + ", direccion=" + direccion + ", conciertos="
				+ conciertos + "]";
	}


	
}
