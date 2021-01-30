package com.sda.weatherservice.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationController {
    private final LocationMapper locationMapper = new LocationMapper();
    private final LocationRepositoryImpl locationRepositoryImpl = new LocationRepositoryImpl();
    private final LocationService locationService = new LocationService(locationRepositoryImpl);
    private final ObjectMapper objectMapper = new ObjectMapper();
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

    public String getLocations() {
        List<LocationDTO> locationDTOs = locationService.getLocations().stream()
                .map(locationMapper::asLocationDTO)
                .collect(Collectors.toList());

        try {
            return objectMapper.writeValueAsString(locationDTOs);
        } catch (JsonProcessingException e) {
            return "Wystąpił problem z serializacją odpowiedzi: " + e.getMessage();
        }
    }
}
