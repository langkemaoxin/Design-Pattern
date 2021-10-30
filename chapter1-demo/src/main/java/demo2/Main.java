package demo2;

public class Main {
}


/**
 *
 * 代码重复，无法复用代码
 *
 * 这里的fly方法，大多数都一样，现在却无法重复使用
 *
 *
 */

interface Flyable{
    void fly();
}
interface Quackable{}

class Duck{

    protected void swim(){}

    protected void fly(){}
}


class MallardDuck extends Duck implements Flyable{

    public void fly() {
        System.out.println("会飞");
    }
}


class RadHeaddDuck extends Duck implements Flyable{

    public void fly() {
        System.out.println("会飞");
    }
}

class RubbreDuck extends Duck implements Flyable{

    public void fly() {
        System.out.println("会飞");
    }
}


class DecoyDuck extends Duck implements Flyable{

    public void fly() {
        System.out.println("会飞");
    }
}
