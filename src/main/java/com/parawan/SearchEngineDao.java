package com.parawan;

public interface SearchEngineDao {

    Beach search(Beach beach);
    boolean checkIfNoNearbyMeetsSpecifiedCriteria(Place temporaryPlace);
}
