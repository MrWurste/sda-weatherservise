package com.sda.weatherservice.backend.models.currentweather;

public class Main {
    public double temp;
    public int pressure;
    public int humidity;

    private double celsius = temp - 273.15;
    @Override
    public String toString() {
        return "\ntemeratura: " + temp + "° K " + celsius + "° C" +
                "\nciśnienie: " + pressure + " mbar" +
                "\nwilgotność: " + humidity + "%";
    }
}
