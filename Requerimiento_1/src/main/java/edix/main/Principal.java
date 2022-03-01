package edix.main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Principal {

	public static void main(String[] args) {

		DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
		DocumentBuilder analizador;
		Document doc;

		try {

			analizador = fabrica.newDocumentBuilder();
			doc = analizador.newDocument();
			Element concierto = doc.createElement("concierto");
			doc.appendChild(concierto);
			agregar(concierto, doc);
			guardar(doc);
			System.out.println("El archivo se ha creado con exito");
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public static void agregar(Element concierto, Document doc) {

		// ---- Fecha ----
		Element fecha = doc.createElement("fecha");
		fecha.appendChild(doc.createTextNode("20-oct-2018"));
		concierto.appendChild(fecha);

		// ---- Hora ----
		Element hora = doc.createElement("hora");
		hora.appendChild(doc.createTextNode("21:30"));
		concierto.appendChild(hora);

		// ---- Participantes ----
		Element participantes = doc.createElement("participantes");
		Element participante = doc.createElement("participante");
		Element entrada = doc.createElement("entrada");
		Element grupo = doc.createElement("grupo");

		// ---- 1er Participante ----
		entrada.appendChild(doc.createTextNode("21:30"));
		grupo.appendChild(doc.createTextNode("Las Ardillas de Dakota"));
		participante.appendChild(entrada);
		participante.appendChild(grupo);
		participantes.appendChild(participante);

		// ---- 2º Participante ----
		participante = doc.createElement("participante");
		entrada = doc.createElement("entrada");
		grupo = doc.createElement("grupo");
		entrada.appendChild(doc.createTextNode("22:15"));
		grupo.appendChild(doc.createTextNode("Fito y Fitipaldis"));
		participante.appendChild(entrada);
		participante.appendChild(grupo);
		participantes.appendChild(participante);

		// ---- 3er Participante ----
		participante = doc.createElement("participante");
		entrada = doc.createElement("entrada");
		grupo = doc.createElement("grupo");
		participantes.appendChild(participante);
		entrada.appendChild(doc.createTextNode("23:00"));
		grupo.appendChild(doc.createTextNode("ColdPlay"));
		participante.appendChild(entrada);
		participante.appendChild(grupo);

		// ---- Concierto ----
		concierto.appendChild(participantes);

	}

	private static void guardar(Document doc) throws TransformerException {

		TransformerFactory fabricaConversor = TransformerFactory.newInstance();
		Transformer conversor = fabricaConversor.newTransformer();
		DOMSource fuente = new DOMSource(doc);
		StreamResult resultado = new StreamResult(new File("concierto.xml"));
		conversor.transform(fuente, resultado);
	}

}
