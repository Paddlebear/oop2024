package jtm.activity06;

public class Human implements Humanoid{

    int stomach;
    boolean alive;

    public Human() {
        alive = true;
    }

    @Override
    public void eat(Integer food) {
        if (stomach == 0) {
            stomach = food;
        }
    }

    @Override
    public Object vomit() {
        int temp = stomach;
        stomach = 0;
        return temp;
    }

    @Override
    public String isAlive() {
        if (alive = true) {
            return "Alive";
        }
        return "Dead";
    }

    @Override
    public String killHimself() {
        alive = false;
        return this.isAlive();
    }

    @Override
    public int getWeight() {
        return stomach + Humanoid.BirthWeight;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getWeight() + " [" + stomach + "]";
    }
}
