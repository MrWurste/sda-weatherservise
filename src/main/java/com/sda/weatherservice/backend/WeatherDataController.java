package com.sda.weatherservice.backend;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherDataController {

    private final WeatherDataMapper weatherDataMapper = new WeatherDataMapper();
    private final WeatherDataRepository weatherDataRepository = new WeatherDataRepositoryImpl();
    private final WeatherDataServise weatherDataServise = new WeatherDataServise(weatherDataRepository);

    public String getWeatherDatas() {
        weatherDataServise.manageGettingJSONAndSavingDataToDatabase();
        List<WeatherDataDTO> weatherDataDTOS = weatherDataServise.getWeatherData().stream()
                .map(weatherDataMapper::asWeatherDataDTO)
                .collect(Collectors.toList());

            return weatherDataDTOS.toString();
    }
}
