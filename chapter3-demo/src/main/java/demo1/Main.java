package demo1;

public class Main {
}

abstract class  Beverage{
    protected String description;

    public abstract String getDescription();
    public abstract int cost();
}

class HouseBlend extends Beverage{

    public String getDescription() {
        return null;
    }

    public int cost() {
        return 0;
    }
}

class DarkRoast extends Beverage{

    public String getDescription() {
        return null;
    }

    public int cost() {
        return 0;
    }
}

