package com.sda.weatherservice.backend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LocationRepositoryMock implements LocationRepository{
    List<Location> locations = new ArrayList<>();
    @Override
    public Location saveNewLocation(Location location) {
        locations.add(location);
        return location;
    }

    @Override
    public List<Location> findAllLocations() {
        return Collections.unmodifiableList(locations);
    }
}
