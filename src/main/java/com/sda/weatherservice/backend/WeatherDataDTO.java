package com.sda.weatherservice.backend;

import lombok.Data;

import java.text.NumberFormat;

@Data
public class WeatherDataDTO {
    private double temperature;
    private int pressure;
    private int humidity;
    private double wind_speed;
    private int wind_degree;

    private double celsius;

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(4);
        return "\ntemeratura: " + temperature + " K, " + nf.format(celsius) + "° C" +
                "\nciśnienie: " + pressure + " mbar" +
                "\nwilgotność: " + humidity + "%" +
                "\nprędkość wiatru: " + wind_speed + " km/h" +
                "\nkierunek wiatru: " + wind_degree + "°\n";
    }
}
