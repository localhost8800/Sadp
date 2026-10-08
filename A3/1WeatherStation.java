/*
1. Write a JAVA Program to implement built-in support (java.util.Observable) Weather
station with members temperature, humidity, pressure and methods
measurementsChanged(), set Measurement(), getTemperature(), getHumidity(),
getPressure()

*/
import java.util.Observable;
import java.util.Observer;

// WeatherData class
class WeatherData extends Observable
{
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged()
    {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature,
                                float humidity,
                                float pressure)
    {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    public float getTemperature()
    {
        return temperature;
    }

    public float getHumidity()
    {
        return humidity;
    }

    public float getPressure()
    {
        return pressure;
    }
}

// Display class
class CurrentConditionsDisplay implements Observer
{
    public void update(Observable observable, Object arg)
    {
        WeatherData weatherData = (WeatherData) observable;

        System.out.println("Current Weather Conditions:");
        System.out.println("Temperature: "
                + weatherData.getTemperature() + " C");

        System.out.println("Humidity: "
                + weatherData.getHumidity() + " %");

        System.out.println("Pressure: "
                + weatherData.getPressure() + " hPa");

        System.out.println();
    }
}

// Main class
public class 1WeatherStation
{
    public static void main(String[] args)
    {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay display =
                new CurrentConditionsDisplay();

        weatherData.addObserver(display);

        weatherData.setMeasurements(25.5f, 65.0f, 1012.5f);
        weatherData.setMeasurements(28.0f, 70.0f, 1010.2f);
        weatherData.setMeasurements(30.5f, 75.0f, 1008.5f);
    }
}
