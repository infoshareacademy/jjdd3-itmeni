package com.parawan;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="PlaceStatus")
@XmlEnum
public enum PlaceStatus{
    FREE,
    BOOKED,
    RESERVED,
    OUTOFORDER,
    DIRTY
}