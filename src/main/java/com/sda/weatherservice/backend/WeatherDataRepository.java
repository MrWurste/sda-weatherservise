package com.sda.weatherservice.backend;

import java.util.List;

public interface WeatherDataRepository {
    List<String> findAllLocationsNames();
    List<WeatherData> saveNewData(List<WeatherData> weatherDataList);
    List<WeatherData> findAllWeatherData();
}
