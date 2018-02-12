package com.parawan.com.menu;

import com.parawan.Beach;
import com.parawan.JavaToXML;
import com.parawan.Places;

import javax.xml.bind.JAXBException;

public class Exit {
    public boolean quitMenu(boolean flag, Beach beach, JavaToXML javaToXML) {
        flag = false;
        try {
            javaToXML.savePlacesToXML((Places)beach.getPlaces());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Thank you for using PARAWAN - your private beach management system");
        return flag ;
    }
}
