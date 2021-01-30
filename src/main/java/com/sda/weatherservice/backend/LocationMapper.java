package com.sda.weatherservice.backend;

public class LocationMapper {

    LocationDTO asLocationDTO(Location location) {
        LocationDTO locationDTO = new LocationDTO();
        locationDTO.setName(location.getName());
        locationDTO.setCountry(location.getCountry());
        locationDTO.setLatitude(location.getLatitude());
        locationDTO.setLongitude(location.getLatitude());
        location.getRegion().ifPresent(locationDTO::setRegion);

        return locationDTO;
    }
}
