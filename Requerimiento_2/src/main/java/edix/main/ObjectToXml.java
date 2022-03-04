package edix.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edix.beans.Cancion;
import edix.beans.Concierto;
import edix.beans.Direccion;
import edix.beans.Festival;
import edix.beans.Grupo;
import edix.beans.Integrante;

public class ObjectToXml {
	
	public static void main(String[] args) {
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(Festival.class);
		} catch (JAXBException e) {
			System.out.println("Error creando el contexto");
			e.printStackTrace();			
			return;
		}
		
		Marshaller m;
		
		try {
			m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			Festival festival = new Festival();
			festival = crearFestival(festival);
			m.marshal(festival, new File("festival.xml"));
			System.out.println("Archivo creado con exito");
			
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	private static Festival crearFestival(Festival festival) {
		List<Integrante> integrantes;
		List<Cancion> canciones;
		List<Concierto> conciertos;
		// --festival--
		festival.setNombre("Festival de Madrid");
		festival.setFecha("16-03-2022");
		festival.setHora("16:00");
		
		// --direccion--
		Direccion direccion = new Direccion("Recoletos", 5, "Madrid");
		festival.setDireccion(direccion);	
		
		// --Grupo1--		
		integrantes = new ArrayList<Integrante>();
		integrantes.add(new Integrante("Avril Lavigne", 37, "Cantante"));
		integrantes.add(new Integrante("Evan Taubenfeld", 38, "Bateria"));
		integrantes.add(new Integrante("Dan Ellis", 38, "Guitarrista"));
		canciones = new ArrayList<Cancion>();
		canciones.add(new Cancion("Girlfriend", "3:50"));
		canciones.add(new Cancion("Bois Lies", "2:43"));
		canciones.add(new Cancion("Sk8er Boi", "3:00"));		
		Grupo grupo1 = new Grupo("Grupo 1", integrantes, canciones);
		
		// --Grupo2--
		integrantes = new ArrayList<Integrante>();
		integrantes.add(new Integrante("Lit Killah", 22, "Cantante"));
		integrantes.add(new Integrante("Trueno", 19, "Cantante"));
		integrantes.add(new Integrante("Nicky Nicole", 21, "Cantante"));
		integrantes.add(new Integrante("Duki", 23, "Cantante"));
		canciones = new ArrayList<Cancion>();
		canciones.add(new Cancion("Dance Crip", "3:50"));
		canciones.add(new Cancion("Entre Nosotros", "2:43"));
		canciones.add(new Cancion("Mala Mia", "3:00"));		
		Grupo grupo2 = new Grupo("Grupo 2", integrantes, canciones);
		
		
		// --Conciertos--
		conciertos = new ArrayList<Concierto>();
		conciertos.add(new Concierto("Concierto 1","16:30", grupo1));
		conciertos.add(new Concierto("Concierto 2","18:30", grupo2));
		festival.setConciertos(conciertos);
		
		return festival;
	}

}
