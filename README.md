# AD-4 Manejo de XML

## Objetivos:

### Requerimiento 1

La clase **Principal** de la aplicación crea un archivo llamado **concierto.xml** con el siguiente contenido:

```

<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<concierto>
	<fecha>20-oct-2018</fecha>
	<hora>21:30</hora>
	<participantes>
		<participante>
			<entrada>21:30</entrada>
			<grupo>Las Ardillas de Dakota</grupo>
		</participante><participante>
			<entrada>22:15</entrada>
			<grupo>Fito y Fitipaldis</grupo>
		</participante><participante>
			<entrada>23:00</entrada>
			<grupo>ColdPLay</grupo>
			</participante>
		</participantes>
</concierto>
```

Dentro del mismo proyecto, la clase llamada **LecturaXML** lee el fichero anteriormente creado, generando la siguiente salida en pantalla:

```
Fecha y hora del concierto: 20-oct-2018 21:30
Participan lo siguientes grupos:
    21:30 Las Ardillas de Dakota
    22:15 Fito y Fitipaldis
    23:00 ColdPLay
```

### Requerimiento 2 (JAXB)

El objetivo es trabajar con un XML, pero con las librerías de JAXB

Se crearán al menos 2 clases (entidades). Entre dichas clases habrá una relación de 1 a N . Las clases llevarán anotaciones JAXB para poder serializar sus objetos a XML y a la inversa.

La clase main creará objetos y los serializará a un fichero XML. También a partir de un XML, creará los objetos.

## Información JDOM

JDOM son librerías java que están incluidas en la jdk, y nos sirven para trabajar con el árbol DOM. Todo documento xml se suele transforman en los navegadores en un árbol de nodos u objetos (como el DOM de XML HTML).
Cada etiqueta XML se transforma en un nodo elemento, los textos en un nodo texto y los atributos se transforman en un nodo atributo

**PRINCIPALES CLASES Y MÉTODOS USADOS para crear un archivo XML** **(Principal.java)**

- **DocumentBuilderFactory :** con su método para instanciarlo **`newInstance()`** Factoría que crea los objetos a través del método **`newDocumentBuilder()`** . Su función es evitar el acoplamiento de clases
- **DocumentBuilder :** y su método **`newDocument()`** Crea objetos complejos de manera simple.
- **Document :** y su método **`getDocumentElement()`** para crear el nodo document.
- **Node :** para crear un nodo.
- **Element :** crea un nodo Elemento con a través del objeto de la clase Document y de su método **`createElement("")`**. Con el método de `Document **appendChild("")**` agregamos e hijos a los nodos.
- **Text :** para crear nodos texto a través del método de la clase `Document createTextNode("");`

Para guardar el archivo xml utilizaremos:

- **TransformerFactory :** se instancia con `newInstance()` y es una fábrica de transformers:
- **Transformer :** a través del método de `TransformerFactory **newTransformer()**` Crea el objeto Transfomer, que nos permite serializar el árbol dom a un fichero.
- **DOMSource :** Crea la fuente de la cual sacaremos el árbol dom.
- **StreamResult :** Crea el flujo de salida, al fichero que queremos, utilizando **`new File("")`** para crear el fichero con la extensión que indiquemos.
- Por último el método de la clase `Transformer **transform(fuente, resultado)**` serializa los datos al pasarle como parámetros un objeto de la clase `DOMSource` y otro objeto de la clase `StreamResult`.

**PRINCIPALES CLASES Y MÉTODOS USADOS para leer un archivo XML** **(LecturaXML.java)**

Además de los usados para crear el XML usaremos:

- **Nodelist :** Para obtener la lista de nodos del documento a través del método del objeto Node de la raíz **`getChildNodes()`**.
- El método **`getNodeName()`** de Nodelist que usamos para obtener el nombre de cada nodo si lo recorremos con un for.
- El método **`getTextContent()`** de Nodelist lo usamos para obtener el String contenido en el nodo.
- El método `getElementsByTagName()` , nos permite pasarle un nombre de la lista de nodos que queremos recibir.

## Información JAXB

Java JAXB o Java XML API Binding nos permite trabajar con XML y JSON de una forma cómoda usando Java.

Antes de Java 11, las librerías de JAXB estaban dentro de la JDK de Java, pero para esta versión las sacaron de ella, por lo que hay que descargarlas y agregarlas al classpath de nuestro proyecto. En este caso se ha utilizado Maven para gestionar las dependencias.
[https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.4.0-b180830.0359](https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api/2.4.0-b180830.0359)

*ANOTACIONES USADAS **

- **`@XmlRootElement(name=" ")`** : anotación obligatoria que establece el nombre del nodo raíz en XML.
- **`@XmlType(propOrder = {	})`** : para que las etiquetas salgan en el orden que pongamos.
- **`@XmlAttribute(name = " ")`** : en vez de pasar  el atributo como element del XML lo pasaría como atributo.
- **`@XmlElement(name=" ")`** : para cambiar el nombre del elemento en el XML.
- **`@XmlElementWrapper(name = " ")`** : envuelve el la etiqueta en una etiqueta elemento con el nombre que le pongamos.

**PRINCIPALES CLASES Y MÉTODOS USADOS para serializar un objeto a XML** **(ObjectToXML.java)**

- **JAXBContext :** con el método **`newInstance(Clase.class)`** Obtiene el contexto asociado a la clase indicada, con dicho contexto podremos convertir el objeto a un xml y a la inversa .Provoca una excepción de tipo JAXBException si la clase indicada no cumple los requisitos para la conversión a XML, si no contiene las anotaciones necesarias y no cuenta con un constructor sin argumentos.
- **Marshaller :** junto al método de JAXBCOntext **`createMarshaller()`** Obtiene el objeto Marshaller asociado al contexto. Con dicho objeto podremos convertir un objeto en xml, es decir, lo serializaremos.
- Con el método de Marshaller **`setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)`** con valor true permite que en la conversión a formato XML se incluyan retornos de carro e indentación (sangrado del texto). Está pensado si el archivo resultante lo van a leer personas. Dejarlo false para leerlo desde java para que no cuente los como nodos los retornos de carro.
- Con el método de `Marshaller **marshal(p, System.out)**` podemos imprimir por pantalla	y también podemos crear un fichero con `.marshal(p, new File(""))`;

PRINCIPALES CLASES Y MÉTODOS USADOS para deserializar un XML a un objeto** **(XMLToObject.java)**

- **Unmarshaller :** junto al método de JAXBCOntext `**createUnmarshaller()**` Para convertir un XML en objeto, es decir, lo deserializaremos.