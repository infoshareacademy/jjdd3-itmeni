package com.parawan.datamanager;

import com.parawan.Beach;
import com.parawan.reservation.ReservationTable;

public interface WriteReservationsToFileDao {

    void writeReservationsToFile(ReservationTable reservationTable, Beach beach);
}
