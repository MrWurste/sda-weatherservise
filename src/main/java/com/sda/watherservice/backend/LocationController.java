package com.sda.watherservice.backend;

public class LocationController {

    private LocationRepository locationRepository = new LocationRepository();
    LocationService locationService = new LocationService();

    public String addNewLocation(String name, String latitude, String longitude, String country, String region) {
        try {
            Location location = locationService.addNewLocation(name, latitude, longitude, country, region);
        } catch (IllegalArgumentException e) {
            return ("Błąd dodawnia lokacji :" + e.getMessage());
        }
        // todo pass variables from the location object
        return String.format("Lokacja dodana prawidłowo: [nazwa: %s, szerokość: %s, długość: %s, kraj: %s, region: %s", name, latitude, longitude, country, region);
    }
}
