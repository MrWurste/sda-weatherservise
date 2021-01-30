package com.sda.watherservice.backend;

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
    float latitude;
    @Column (nullable = false)
    float longitude;
    @Column (nullable = false)
    String country;
    String region;

    public Location(String name, float latitude, float longitude, String country, String region) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.country = country;
        this.region = region;
    }
}
