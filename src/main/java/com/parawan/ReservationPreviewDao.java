package com.parawan;

public interface ReservationPreviewDao {

    void preview(Beach beach);
    Place getPlaceByCoordinates(Beach beach, int x, int y);
}
