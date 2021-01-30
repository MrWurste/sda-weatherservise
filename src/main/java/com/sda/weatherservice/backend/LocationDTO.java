package com.sda.weatherservice.backend;

import lombok.Data;

@Data
public class LocationDTO {
String name;
String country;
String region;
float latitude;
float longitude;
}
