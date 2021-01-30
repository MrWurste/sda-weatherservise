package com.sda.watherservice.backend;

import javax.persistence.*;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    float latitude;
    float longtitude;
    String country;
    @Column (nullable = true)
    String region;

    public Location () {}

    public Location(String name, float latitude, float longtitude, String country, String region) {
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.country = country;
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongtitude() {
        return longtitude;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }
}
