package com.sda.weatherservice.backend;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherDataController {
    //todo split downloanding data for every location and one location
    //todo optional - getRidOfDownlanding data for every location - with big Location database may it cause problems
    //todo getOnly chosen weather datas from database, not every existing record
    //todo downloanding data for one location
    //todo add same stuff to future weather
    //todo add to WeatherData entity date and time of forecast
    //todo implement to WeatherData entity OneToMany relation (1 city - many weather datas)

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
