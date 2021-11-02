package demo4;

public class Main {
    public static void main(String[] args) {

        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription()+ " $"+espresso.cost());

        Beverage beverage2 = new Espresso();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Milk(beverage2);
        beverage2 = new Soy(beverage2);
        beverage2 = new BigCup(beverage2);
        System.out.println(beverage2.getDescription()+ " $"+beverage2.cost());

    }
}

abstract class Beverage{
    String description="Unkown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}


/**
 * 具体的咖啡类1
 */
class Espresso extends Beverage{

    public Espresso(){
        description="Espresso";
    }

    public double cost() {
        return 1.99;
    }
}

/**
 * 具体的咖啡类2
 */
class HouseBlend extends Beverage{

    public HouseBlend(){
        description="HouseBlend";
    }

    public double cost() {
        return 0.89;
    }
}



/**
 * 这里的调料能够取代饮料
 */
abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();
}


class Mocha extends CondimentDecorator{

    private Beverage beverage;

    public Mocha(Beverage beverage){

        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost()+0.10;
    }

    public String getDescription() {
        return beverage.getDescription()+",Mocha";
    }
}



class Milk extends CondimentDecorator{

    private Beverage beverage;

    public Milk(Beverage beverage){

        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost()+0.10;
    }

    public String getDescription() {
        return beverage.getDescription()+",Milk";
    }
}


class Soy extends CondimentDecorator{

    private Beverage beverage;

    public Soy(Beverage beverage){

        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost()+0.10;
    }

    public String getDescription() {
        return beverage.getDescription()+",Soy";
    }
}



class smallCup extends CondimentDecorator{

    private Beverage beverage;

    public smallCup(Beverage beverage){

        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost()+0.10;
    }

    public String getDescription() {
        return beverage.getDescription()+",smallCup";
    }
}

class BigCup extends CondimentDecorator{

    private Beverage beverage;

    public BigCup(Beverage beverage){

        this.beverage = beverage;
    }

    public double cost() {
        return beverage.cost()+0.10;
    }

    public String getDescription() {
        return beverage.getDescription()+",BigCup";
    }
}