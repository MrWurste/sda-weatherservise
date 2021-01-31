package com.sda.weatherservice.backend;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@RequiredArgsConstructor
@Data
@Entity
public class WeatherData {
    @Id
    @GeneratedValue
    private long id;
    @Column(nullable = false)
    private double temperature;
    @Column(nullable = false)
    private int pressure;
    @Column(nullable = false)
    private int humidity;
    @Column(nullable = false)
    private double wind_speed;
    @Column(nullable = false)
    private int wind_degree;
    @Column(nullable = false)
    private long city_id;

    public WeatherData(double temperature, int pressure, int humidity, double wind_speed, int wind_degree) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind_speed = wind_speed;
        this.wind_degree = wind_degree;
        this.city_id = city_id;
    }
}
