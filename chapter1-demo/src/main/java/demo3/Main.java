package demo3;

public class Main {
    public static void main(String[] args) {
//        Duck duck=new MallardDuck();
//        duck.performFly();
//        duck.performQuack();


        Duck duck=new ModelDuck();
        duck.performFly();

        duck.setFlyBehavior(new RocketFly());
        duck.performFly();

    }
}

abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void swim(){
        System.out.println("每只鸭子都能游泳");
    }

    public abstract void display();

    public void setFlyBehavior(FlyBehavior flyBehavior){
        this.flyBehavior=flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}

interface FlyBehavior {
    void fly();
}

class FlyWithWings implements FlyBehavior {

    public void fly() {
        System.out.println("有翅膀的飞行");
    }
}

class FlyWithNoWings implements FlyBehavior {

    public void fly() {
        System.out.println("无翅膀的飞行");
    }
}


class RocketFly implements FlyBehavior {

    public void fly() {
        System.out.println("带着火箭的飞行");
    }
}


interface QuackBehavior {
    void quack();
}

class Quack implements QuackBehavior {

    public void quack() {
        System.out.println("真的瓜瓜叫");
    }
}

class Squack implements QuackBehavior {

    public void quack() {
        System.out.println("橡皮鸭吱吱叫");
    }
}

class MuteQuack implements QuackBehavior {

    public void quack() {
        System.out.println("不叫");
    }
}



/////////////////////////////////////////////


class MallardDuck extends Duck{
    public MallardDuck(){
        flyBehavior=new RocketFly();
        quackBehavior=new Quack();
    }

    @Override
    public void display() {
        System.out.println("mallarDuck");
    }
}


class ModelDuck extends Duck{

    public ModelDuck(){
        flyBehavior=new FlyWithNoWings();
        quackBehavior=new MuteQuack();
    }

    public void display() {
        System.out.println("模型鸭子");
    }
}