package demo3;

public class Main {
}


/**
 *
 * 各种调料的价格，以及调料的种类，都是变动的，
 * 这种方式比第二种方式好一点，不会引起爆炸，但是也没有解决扩展问题
 *
 */
abstract class  Beverage{
    protected String description;

    private boolean milk;
    private boolean soy;

    public abstract String getDescription();
    public  float cost(){
        float cost=0;
        if(milk){
            cost+=10;
        }

        if(soy){
            cost+=20;
        }

        return cost;
    }


}

class HouseBlend extends Beverage {

    public String getDescription() {
        return null;
    }

    public float cost() {


        return super.cost()+30;
    }
}

class DarkRoast extends Beverage {

    public String getDescription() {
        return null;
    }

    public float cost() {
        return super.cost()+130;
    }
}

