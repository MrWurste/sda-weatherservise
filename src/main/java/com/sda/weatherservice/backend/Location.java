package com.sda.weatherservice.backend;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Entity
@RequiredArgsConstructor
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String name;
    @Column (nullable = false)
    private String country;
    @Column (nullable = false)
    private float latitude;
    @Column (nullable = false)
    private float longitude;
    private String region;

    public Location(String name, String country, float latitude, float longitude, String region) {
        this.name = name;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.region = region;
    }

    Optional<String> getRegion() {
        return Optional.ofNullable(region);
    }
}
