package com.geekbrains.lavsam.myjavatokotlin.data;

public class WeatherJava {
    private String town;
    private int temperature;

    public WeatherJava(String town, int temperature) {
        this.setTown(town);
        this.setTemperature(temperature);
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
