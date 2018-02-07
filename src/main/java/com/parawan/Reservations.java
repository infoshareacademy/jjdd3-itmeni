package com.parawan;

import java.text.SimpleDateFormat;
import java.util.*;

public class Reservations {


    public void makeReservations(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");

        Calendar today = new GregorianCalendar();
        Calendar tomorrow = new GregorianCalendar();
        Calendar dayAfterTomorrow = new GregorianCalendar();
        System.out.println(today.getClass());


        tomorrow.add(Calendar.DAY_OF_MONTH,+1);
        dayAfterTomorrow.add(Calendar.DAY_OF_MONTH,+2);
        //System.out.println(sdf.format(today.getTime()));
        //System.out.println(sdf.format(tomorrow.getTime()));
        //System.out.println(sdf.format(dayAfterTomorrow.getTime()));
        Map<Integer, PlaceStatus > innerMap = new TreeMap<Integer, PlaceStatus>();
        for(int i=8; i<20; i++){
            innerMap.put(i, PlaceStatus.FREE);
        }
        Map<Calendar, Map> outerMap= new TreeMap<Calendar, Map>();
        outerMap.put(today, innerMap);
        outerMap.put(tomorrow, innerMap);
        outerMap.put(dayAfterTomorrow, innerMap);



    }



}
