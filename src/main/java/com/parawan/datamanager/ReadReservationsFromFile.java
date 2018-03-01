package com.parawan.datamanager;

import com.parawan.Beach;
import com.parawan.ItemType;
import com.parawan.reservation.Reservation;
import com.parawan.reservation.ReservationTable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

public class ReadReservationsFromFile{

    public Beach constructBeachFromFile() throws IOException{
        BufferedReader br=new BufferedReader(new FileReader("database.beach"));
        String line=br.readLine();
        String[] beachParameters=line.split(";");
        return new Beach(beachParameters[0], Integer.parseInt(beachParameters[1]), Integer.parseInt(beachParameters[2]));
    }

    public ReservationTable constructReservationTableFromFile() throws IOException{
        ReservationTable reservationTable=new ReservationTable();
        LineNumberReader lnr=new LineNumberReader(new FileReader("database.beach"));
        for(String line=null; (line=lnr.readLine())!=null; ){
            if(lnr.getLineNumber()>1){
                String[] reservationParameters=line.split(";");
                String[] itemsList=reservationParameters[2].split(" ");
                List<ItemType> items=createListOfItems(itemsList);
                Reservation reservation=new Reservation(Integer.parseInt(reservationParameters[0]),
                        Integer.parseInt(reservationParameters[1]), items, reservationParameters[3]);
                reservationTable.add(reservation);
            }
        }
        return reservationTable;
    }

    public List<ItemType> createListOfItems(String[] list){
        List<ItemType> items=new ArrayList<>();
        if(!(list[0].equals(""))){
            for(String itemName : list){
                items.add(ItemType.valueOf(itemName));
            }
        }
        return items;
    }
}
