package com.parawan;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "PlaceStatus")
@XmlEnum
public enum PlaceStatus {
    FREE,
    OCCUPIED, // field will be used when the booking system will annotate the hours
    RESERVED,
    DIRTY
}