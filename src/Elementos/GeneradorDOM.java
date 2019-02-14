/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;
import ACME.*;
import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *
 * @author josec
 */
public class GeneradorDOM {
    private Document document;
    
    public GeneradorDOM() throws ParserConfigurationException{
        DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
        DocumentBuilder build = fact.newDocumentBuilder();
        document = build.newDocument();
    }
    
    public void generarDocument(){
        Element cuevas = document.createElement("Cuevas");
        document.appendChild(cuevas);
        Element cueva = document.createElement("Cueva");
        cuevas.appendChild(cueva);
        Element cantidad = document.createElement("Cantidad");
        cueva.appendChild(cantidad);
        Element material = document.createElement("Material");
        cueva.appendChild(material);
    }
    
    public void agregarCuevas(int i, String mater){
        try {
            DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = fact.newDocumentBuilder();
            Document doc = build.parse(new File("/home/josec/Documentos/Netbeans Projects/ElParo/Cuevas.xml"));
            
            doc.getDocumentElement().normalize();
            Node nodoRaiz = doc.getDocumentElement();
            Element nuevaCueva = doc.createElement("Cueva");
            Element nuevaCant = doc.createElement("Cantidad");
            nuevaCant.setTextContent(""+i);
            Element nuevoMater = doc.createElement("Material");
            nuevoMater.setTextContent(mater);
            
            nuevaCueva.appendChild(nuevaCant);
            nuevaCueva.appendChild(nuevoMater);
            nodoRaiz.appendChild(nuevaCueva);
            
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transform = tf.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("/home/josec/Documentos/Netbeans Projects/ElParo/Cuevas.xml"));
            transform.transform(source, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void generarXML() throws Exception{
        TransformerFactory fact = TransformerFactory.newInstance();
        Transformer transformer = fact.newTransformer();
        
        Source source = new DOMSource(document);
        File file = new File("Cuevas.xml");
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw); 
        Result result = new StreamResult(pw);
        transformer.transform(source, result);
    }
}
