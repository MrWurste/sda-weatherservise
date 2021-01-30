package com.sda.weatherservice.backend.models.currentweather;

public class Wind {
    public double speed;
    public int deg;

    @Override
    public String toString() {
        return "\nprędkość wiatru: " + speed + " km/h" +
                "\nkierunek wiatru: " + deg + "°";
    }
}
