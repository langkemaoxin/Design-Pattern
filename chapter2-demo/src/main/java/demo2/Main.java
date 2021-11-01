package demo2;

import java.util.Observable;
import java.util.Observer;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);


        weatherData.setMeasurements(80,65,34.4f);
    }
}



interface DisplayElement{
    void display();
}

class WeatherData extends Observable {

    public WeatherData(){

    }


    private float temperature;

    private float humidity;

    private float pressure;

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }


    public void measurementsChanged(){

        setChanged();

        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
}

class CurrentConditionsDisplay implements Observer, DisplayElement {

    private Observable observable;

   private float temperature;
   private float humidity;


   public CurrentConditionsDisplay(Observable observable){
       this.observable = observable;
       observable.addObserver(this);
   }

   public void update(float temp, float humidity, float pressure) {
       this.temperature=temp;
       this.humidity=humidity;
       display();
   }

   public void update(Observable obs,Object arg){
       if(arg instanceof WeatherData){
           WeatherData weatherData = (WeatherData) arg;
           this.temperature=weatherData.getTemperature();
           this.humidity=weatherData.getHumidity();
           display();
       }
   }

   public void display() {
       System.out.println("现在的温读是："+temperature+" 湿度："+humidity);
   }
}