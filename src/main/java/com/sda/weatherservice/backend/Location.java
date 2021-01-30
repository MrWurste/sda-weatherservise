package com.sda.weatherservice.backend;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column (nullable = false)
    String name;
    @Column (nullable = false)
    String country;
    @Column (nullable = false)
    float latitude;
    @Column (nullable = false)
    float longitude;
    String region;

    public Location(String name, String country, float latitude, float longitude, String region) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.region = region;
    }
}
