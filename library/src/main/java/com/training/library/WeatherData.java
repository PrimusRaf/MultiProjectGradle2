package com.training.library;

import lombok.Data;

@Data
public class WeatherData {

    private float temperature;
    private float humidity;
    private float pressure;
    private float windSpeed;
    private float windDirection;
    private float windBearing;
    private float windGust;
    private float windPower;

}
