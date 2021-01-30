package com.sda.weatherservice.backend;

import lombok.Data;

@Data
public class LocationDTO {
    private String name;
    private String country;
    private String region;
    private float latitude;
    private float longitude;
}
