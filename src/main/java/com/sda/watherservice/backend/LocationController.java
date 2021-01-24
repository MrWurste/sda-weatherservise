package com.sda.watherservice.backend;

public class LocationController {

    private LocationRepository locationRepository = new LocationRepository();
    LocationService locationService = new LocationService();

    public String addNewLocation(String name, String latitude, String longitude, String country, String region) {
        try {
            locationService.Validate(name, latitude, longitude, country, region);
        } catch (IllegalArgumentException e) {
            return ("Błąd dodawnia lokacji :" + e.getMessage());
        }
        return String.format("Lokacja dodana prawidłowo: [nazwa: %s, szerokość: %s, długość: %s, kraj: %s, region: %s", name, latitude, longitude, country, region);
    }
}
