package com.sda.weatherservice.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LocationController {
    private final LocationMapper locationMapper = new LocationMapper();
    private final LocationRepository locationRepository = new LocationRepositoryImpl();
    private final LocationService locationService = new LocationService(locationRepository);
    private final ObjectMapper objectMapper = new ObjectMapper();
    Location location;

    public String addNewLocation(String name, String country, String latitude, String longitude, String region) {
        try {
            name = name.toLowerCase();
            country = country.toLowerCase();
            region = Optional.ofNullable(region).map(String::toLowerCase).orElse(null);
            location = locationService.addNewLocation(name, country, latitude, longitude, region);
        } catch (IllegalArgumentException e) {
            return "Błąd dodawnia lokacji :" + e.getMessage();
        }

        return String.format("Lokacja dodana prawidłowo: [nazwa: %s, kraj: %s, szerokość: %s, długość: %s, region: %s",
                location.getName(),
                location.getCountry(),
                location.getLatitude(),
                location.getLongitude(),
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

    public boolean checkIfLocationIsInDataBase(String name) {
        return locationService.repo.checkIfExist(name);
    }
}
