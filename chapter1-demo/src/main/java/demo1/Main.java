package demo1;

public class Main {
}

class Duck{
    protected void quack(){}

    protected void swim(){}

    protected void display(){}

    protected void fly(){}
}


class MallardDuck extends Duck{
    @Override
    protected void display() {
        super.display();
    }
}


class RadHeaddDuck extends Duck{
    @Override
    protected void display() {
        super.display();
    }
}

class RubbreDuck extends Duck{
    @Override
    protected void display() {
        super.display();
    }

    @Override
    protected void quack() {
        super.quack();
    }

    @Override
    protected void fly() {
        //
    }
}


class DecoyDuck extends Duck{
    @Override
    protected void display() {
      //
    }

    @Override
    protected void quack() {
        super.quack();
    }

    @Override
    protected void fly() {
        //
    }
}


