package com.sda.watherservice.backend;

public class LocationController {

    private LocationRepositoryImpl locationRepositoryImpl = new LocationRepositoryImpl();
    LocationService locationService = new LocationService(locationRepositoryImpl);
    Location location;

    public String addNewLocation(String name, String latitude, String longitude, String country, String region) {
        try {
            if (region==null) {
                location = locationService.addNewLocation(
                        name.toLowerCase(),
                        latitude,
                        longitude,
                        country.toLowerCase(),
                        region);
            } else {
                location = locationService.addNewLocation(
                        name.toLowerCase(),
                        latitude,
                        longitude,
                        country.toLowerCase(),
                        region.toLowerCase());
            }
        } catch (IllegalArgumentException e) {
            return ("Błąd dodawnia lokacji :" + e.getMessage());
        }
        return String.format("Lokacja dodana prawidłowo: [nazwa: %s, szerokość: %s, długość: %s, kraj: %s, region: %s",
                location.getName(),
                location.getLatitude(),
                location.getLongtitude(),
                location.getCountry(),
                location.getRegion());
    }
}
