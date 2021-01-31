package com.sda.weatherservice.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherDataController {

    private final WeatherDataMapper weatherDataMapper = new WeatherDataMapper();
    private final WeatherDataRepository weatherDataRepository = new WeatherDataRepositoryImpl();
    private final WeatherDataServise weatherDataServise = new WeatherDataServise(weatherDataRepository);
    private final ObjectMapper objectMapper = new ObjectMapper();

    List<WeatherData> weatherDatas = new ArrayList<>();
    public void saveAllWeatherData (List<WeatherData> list) {
        weatherDataServise.saveAllWeatherData(list);
    }

    public String getWeatherDatas() {
        weatherDataServise.doEverythinkCouseIDontKnowWhatImDoing();
        List<WeatherDataDTO> weatherDataDTOS = weatherDataServise.getWeatherData().stream()
                .map(weatherDataMapper::asWeatherDataDTO)
                .collect(Collectors.toList());

        //try {
            //return objectMapper.writeValueAsString(weatherDataDTOS);
            return weatherDataDTOS.toString();
        //} catch (JsonProcessingException e) {
         //   return "Niepowodzenie w pozyskaniu danych pogodowych: "+e.getMessage();
        //}
    }
}
