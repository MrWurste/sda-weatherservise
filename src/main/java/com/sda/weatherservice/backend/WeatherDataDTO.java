package com.sda.weatherservice.backend;

import lombok.Data;

@Data
public class WeatherDataDTO {
    private double temperature;
    private int pressure;
    private int humidity;
    private double wind_speed;
    private int wind_degree;
}
