package edix.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LecturaXML {

	public static void main(String[] args) {

		File file = new File("concierto.xml");

		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			Node raiz = doc.getDocumentElement();

			NodeList participantes = doc.getElementsByTagName("participante");
			NodeList concierto = raiz.getChildNodes();

			String fecha = concierto.item(0).getTextContent();
			String hora = concierto.item(1).getTextContent();

			System.out.println("Fecha y hora del concierto: " + fecha + " " + hora);

			System.out.println("Participan los siguientes grupos:");

			for (int i = 0; i < participantes.getLength(); i++) {
				Node participante = participantes.item(i);

				if (participante.getNodeType() == Node.ELEMENT_NODE) {
					Node inicio = participante.getChildNodes().item(0);
					Node grupo = participante.getChildNodes().item(1);
					System.out.println("  " + inicio.getTextContent() + "  " + grupo.getTextContent());

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
