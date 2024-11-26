package com.training.library;

public class WeatherApiProvider {

    public static WeatherApi getApi() {
        return new WeatherApiImpl();
    }
}
