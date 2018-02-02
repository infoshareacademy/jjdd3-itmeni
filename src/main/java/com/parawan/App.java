package com.parawan;

import com.sun.xml.internal.bind.v2.model.core.ID;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class App {
    public static void main(String[] args) throws FileNotFoundException, JAXBException {

        JavaToXML myXML = new JavaToXML();
        myXML.javaToXML();
    }
}
