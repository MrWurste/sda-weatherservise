package com.sda.weatherservice.backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sda.weatherservice.backend.models.CurrentWeatherModel;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

//todo delete before merge to develop after finishing feature
public class WeatherDataDownander {
    static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        //System.out.println(buildURILink("lublin","c22273871df9b8f551e3bf3ef88443ca"));
        try {
            remapCurrentWeatherData(buildURILink("lublin","c22273871df9b8f551e3bf3ef88443ca"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    static URL buildURILink (String name, String apiid) {
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
    static void remapCurrentWeatherData(URL jsonLink) throws JsonProcessingException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        CurrentWeatherModel weather = null;
        try {
            weather = mapper.readValue(jsonLink, CurrentWeatherModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(weather.toString());
    }
}
