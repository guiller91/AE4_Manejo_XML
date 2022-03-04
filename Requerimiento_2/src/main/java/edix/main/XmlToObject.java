package edix.main;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edix.beans.Cancion;
import edix.beans.Concierto;
import edix.beans.Festival;
import edix.beans.Grupo;
import edix.beans.Integrante;

public class XmlToObject {

	public static void main(String[] args) {
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(Festival.class);
			
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("festival.xml");
			if (fichero.exists()) {
				Festival festival = (Festival) u.unmarshal(fichero);			
				listar(festival);
			} else {
				System.out.println("Fichero XML festival.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}
	
	static void listar(Festival festival) {
		
		System.out.println("El " + festival.getNombre() + " dara comienzo el " + festival.getFecha() + " " + festival.getHora());
		System.out.println("En la calle " + festival.getDireccion().getCalle() + ", " + festival.getDireccion().getNumero()
							+", " + festival.getDireccion().getCiudad());
		System.out.println("Los conciertos son los siguientes: ");
		
		for (int i=0; i<festival.getConciertos().size();i++) {
			Concierto c = festival.getConciertos().get(i);
			Grupo grupo = c.getGrupo();
			System.out.println("--------------------------------\n");
			System.out.println(c.getNombre() + " empieza a las " + c.getHora());
			System.out.println("Tocara : " + grupo.getNombre());
			System.out.println("\n<---INTEGRANTES--->\n");
			for(Integrante integrante : grupo.getIntegrantes()) {
				System.out.println(integrante.getNombre() + ", rol: " + integrante.getRol() + ", edad: " + integrante.getEdad());
			}
			System.out.println("\n<---CANCIONES--->\n");
			for(Cancion cancion : grupo.getCanciones()) {
				System.out.println(cancion.getNombre() + ", duracion: " + cancion.getDuracion() );
			}
			
			
		}
		
	}

}
