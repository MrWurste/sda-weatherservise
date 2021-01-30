package com.sda.watherservice.backend;

import java.util.List;

public class LocationRepositoryMock implements LocationRepository{
    List<Location> locations;
    @Override
    public Location saveNewLocation(Location location) {
        locations.add(location);
        return location;
    }
}
