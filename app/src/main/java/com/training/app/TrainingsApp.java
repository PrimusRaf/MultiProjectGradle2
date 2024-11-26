package com.training.app;

import com.training.library.WeatherApi;
import com.training.library.WeatherApiProvider;
import com.training.library.WeatherData;

public class TrainingsApp {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        WeatherApi weatherApi = WeatherApiProvider.getApi();
        WeatherData weatherData = weatherApi.fetchCurrentWeather();
    }
}
