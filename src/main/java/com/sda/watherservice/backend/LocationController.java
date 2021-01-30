package com.sda.watherservice.backend;

import java.util.Optional;

public class LocationController {

    private LocationRepositoryImpl locationRepositoryImpl = new LocationRepositoryImpl();
    LocationService locationService = new LocationService(locationRepositoryImpl);
    Location location;

    public String addNewLocation(String name, String latitude, String longitude, String country, String region) {
        try {
            name = name.toLowerCase();
            country = country.toLowerCase();
            region = Optional.ofNullable(region).map(String::toLowerCase).orElse(null);
            location = locationService.addNewLocation(name, latitude, longitude, country, region);
        } catch (IllegalArgumentException e) {
            return "Błąd dodawnia lokacji :" + e.getMessage();
        }

        return String.format("Lokacja dodana prawidłowo: [nazwa: %s, szerokość: %s, długość: %s, kraj: %s, region: %s",
                location.getName(),
                location.getLatitude(),
                location.getLongitude(),
                location.getCountry(),
                location.getRegion());
    }
}
