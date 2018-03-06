package com.parawan.controler;

import com.parawan.dao.ReservationDao;
import com.parawan.model.Reservation;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CheckIfPlaceIsAlreadyReserved  {

    @Inject
    ReservationDao reservationDao;

    public boolean doCheck(Reservation reservation){
        Integer hourToCheck = reservation.getHourOfReservation();
        Integer idOfPlaceToCheck = reservation.getPlaceId();

        return false;

    }

}
