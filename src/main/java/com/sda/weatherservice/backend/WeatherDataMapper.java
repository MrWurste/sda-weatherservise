package com.sda.weatherservice.backend;

public class WeatherDataMapper {
    public WeatherDataDTO asWeatherDataDTO(WeatherData weatherData) {
        WeatherDataDTO weatherDataDTO = new WeatherDataDTO();
        weatherDataDTO.setTemperature(weatherData.getTemperature());
        weatherDataDTO.setPressure(weatherData.getPressure());
        weatherDataDTO.setHumidity(weatherData.getHumidity());
        weatherDataDTO.setWind_speed(weatherData.getWind_speed());
        weatherDataDTO.setWind_degree(weatherData.getWind_degree());
        weatherDataDTO.setCelsius(weatherData.getTemperature()-273.15);

        return weatherDataDTO;
    }
}
