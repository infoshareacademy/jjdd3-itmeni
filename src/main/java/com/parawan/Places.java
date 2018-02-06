package com.parawan;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "places")
public class Places extends ArrayList<Place> {
}