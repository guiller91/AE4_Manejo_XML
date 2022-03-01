package edix.main;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import edix.beans.Festival;

public class XmlToObject {

	public static void main(String[] args) {
		
		try {
			JAXBContext contexto = JAXBContext.newInstance(Festival.class);
			
			Unmarshaller u = contexto.createUnmarshaller();
			File fichero = new File("festival.xml");
			if (fichero.exists()) {
				Festival festival = (Festival) u.unmarshal(fichero);			
				System.out.println(festival);
			} else {
				System.out.println("Fichero XML festival.xml no encontrado");
			}

		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}

	}

}
