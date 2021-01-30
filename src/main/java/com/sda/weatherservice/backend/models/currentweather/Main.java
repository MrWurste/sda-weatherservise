package com.sda.weatherservice.backend.models.currentweather;

public class Main {
    public double temp;
    public int pressure;
    public int humidity;

    @Override
    public String toString() {
        return "\ntemeratura: " + temp + "° F" +
                "\nciśnienie: " + pressure + " mbar" +
                "\nwilgotność: " + humidity + "%";
    }
}
