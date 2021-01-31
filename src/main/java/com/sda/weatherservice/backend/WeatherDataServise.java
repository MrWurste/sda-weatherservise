package com.sda.weatherservice.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weatherservice.backend.models.CurrentWeatherModel;
import com.sda.weatherservice.backend.models.currentweather.Main;
import com.sda.weatherservice.backend.models.currentweather.Wind;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class WeatherDataServise {
    static ObjectMapper mapper = new ObjectMapper();
    WeatherDataRepository repo;
    static List<WeatherData> weatherDatas = new ArrayList<>();

    public WeatherDataServise(WeatherDataRepository repository) {
        this.repo = repository;
    }

    public void manageGettingJSONAndSavingDataToDatabase() {
        createWeatherDataForEveryLocation(getAllLocationsNames());
        saveAllWeatherData(weatherDatas);
        weatherDatas.clear();
    }

    public List<String> getAllLocationsNames() {
        return repo.findAllLocationsNames();
    }

    public void createWeatherDataForEveryLocation (List<String> gALFN) {
        for (int i = 0; i < gALFN.size(); i++) {
            try {
                translateJSONtoEntity(buildURLLink(gALFN.get(i), "c22273871df9b8f551e3bf3ef88443ca"));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }
    }

    static URL buildURLLink(String name, String apiid) {
        StringBuilder urisb = new StringBuilder();
        urisb.append("http://api.openweathermap.org/data/2.5/weather");
        urisb.append("?q=");
        urisb.append(name);
        urisb.append("&?mode=xml");
        urisb.append("&appid=");
        urisb.append(apiid);
        try {
            return new URL(urisb.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void translateJSONtoEntity(URL jsonLink) throws JsonProcessingException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CurrentWeatherModel weather = null;
        try {
            weather = mapper.readValue(jsonLink, CurrentWeatherModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        weatherDatas.add(makeEntityFromClasses(weather.main, weather.wind));
    }

    static WeatherData makeEntityFromClasses(Main main, Wind wind) {
        return new WeatherData(main.temp, main.pressure, main.humidity, wind.speed, wind.deg);
    }

    public List<WeatherData> saveAllWeatherData(List<WeatherData> list) {

        return repo.saveNewData(list);
    }

    public List<WeatherData> getWeatherData() {

        return repo.findAllWeatherData();
    }
}
