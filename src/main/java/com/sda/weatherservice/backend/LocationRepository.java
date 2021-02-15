package com.sda.weatherservice.backend;

import java.util.List;

public interface LocationRepository {
    Location saveNewLocation(Location location);

    List<Location> findAllLocations();

    boolean checkIfExist(String name);
}
