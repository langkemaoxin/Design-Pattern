package demo1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay conditionsDisplay = new CurrentConditionsDisplay(weatherData);


        weatherData.setMeasurements(80,65,34.4f);
    }
}


interface Observer{

    /**
     * 这里直接把值传给了 客户端
     *
     * 但是在后期，这个值有可能会被改变，后面的变化是否很好的被封装？
     *
     * @param temp
     * @param humidity
     * @param pressure
     */
    public void update(float temp,float humidity,float pressure);
}


interface Subject{
    void registerObserver(Observer o);
    void removewObserver(Observer o);
    void notifyObservers();
}

interface DisplayElement{
    void display();
}

class WeatherData implements Subject{

    private ArrayList observers;

    private float temperature;

    private float humidity;

    private float pressure;


    public WeatherData(){
        observers=new ArrayList();
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removewObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }

    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer= (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidity,float pressure){
        this.temperature=temperature;
        this.humidity=humidity;
        this.pressure=pressure;
        measurementsChanged();
    }
}

 class CurrentConditionsDisplay implements Observer,DisplayElement{

    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData){
        this.weatherData=weatherData;
        weatherData.registerObserver(this);
    }

    public void update(float temp, float humidity, float pressure) {
        this.temperature=temp;
        this.humidity=humidity;
        display();
    }

    public void display() {
        System.out.println("现在的温读是："+temperature+" 湿度："+humidity);
    }
}