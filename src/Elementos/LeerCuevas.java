/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Elementos;
import ACME.Cueva;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author josec
 */
public class LeerCuevas extends DefaultHandler{
    private LinkedList<Cueva> cuevas = new LinkedList<>();
    private Cueva cueva;
    private StringBuilder buffer = new StringBuilder();
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        buffer.append(ch, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch(qName){
            case "Cantidad":
                cueva.setDato(Integer.parseInt(buffer.toString()));
                break;
            case "Material":
                cueva.setMaterial(buffer.toString());
                break;
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "Cueva":
                cueva = new Cueva();
                getCuevas().add(cueva);
                break;
            case "Cantidad":
            case "Material":
                buffer.delete(0, buffer.length());
                break;
        }
    }

    public LinkedList<Cueva> getCuevas() {
        return cuevas;
    }
    
}
