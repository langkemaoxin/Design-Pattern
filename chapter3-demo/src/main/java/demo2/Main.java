package demo2;

public class Main {
}

abstract class  Beverage{
    protected String description;

    public abstract String getDescription();
    public abstract int cost();
}

/**
 *
 * 不同调料之间的组合，竟然使用类进行实现，导致类爆炸
 *
 */

class HouseBlendWithMilk extends Beverage {

    public String getDescription() {
        return null;
    }

    public int cost() {
        return 0;
    }
}

class HouseBlendWithWipandSoy extends Beverage {

    public String getDescription() {
        return null;
    }

    public int cost() {
        return 0;
    }
}


class HouseBlendWithWipandSoyAndMilk extends Beverage {

    public String getDescription() {
        return null;
    }

    public int cost() {
        return 0;
    }
}


