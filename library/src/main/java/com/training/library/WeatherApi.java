package com.training.library;

public interface WeatherApi {

    WeatherData fetchCurrentWeather();
    WeatherData fetchComingWeather();
    WeatherData fetchPastWeather();
}
