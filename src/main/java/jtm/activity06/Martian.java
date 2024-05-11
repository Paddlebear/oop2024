package jtm.activity06;

public class Martian implements Humanoid, Alien, Cloneable {

    Object stomach;

    public Martian () { }

    @Override
    public void eat(Object item) {
        if (stomach == null) {
            if (item instanceof Human) {
                ((Human)item).killHimself();
            }
            stomach = item;
        }
    }

    @Override
    public void eat(Integer food) {
        eat((Object)food);
    }

    @Override
    public Object vomit() {
        Object temp = stomach;
        stomach = null;
        return temp;
    }

    @Override
    public String isAlive() {
        return "I AM IMMORTAL!";
    }

    @Override
    public String killHimself() {
        return this.isAlive();
    }

    @Override
    public int getWeight() {
        int stomachWeight = 0;
        if (stomach instanceof Integer) {
            stomachWeight = (Integer)stomach;
        }
        if (stomach instanceof Humanoid) {
            stomachWeight = ((Humanoid)stomach).getWeight();
        }
        return stomachWeight + Alien.BirthWeight;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": " + getWeight() + " [" + stomach + "]";
    }
    
    @Override
    public Object clone() throws java.lang.CloneNotSupportedException {
        return clone(this);
    }

    private Object clone(Object curr) {
        if (curr instanceof Integer) {
            return Integer.valueOf((int)curr);
        }
        
        if (curr instanceof Martian) {
            Martian temp = (Martian)curr;
            Martian clone = new Martian();
            clone.eat(clone(temp.stomach));
            return clone;
        }

        if (curr instanceof Human) {
            Human temp = (Human)curr;
            Human clone = new Human();
            clone.eat(Integer.valueOf(temp.stomach));
            return clone;
        }

        return null;
    }

}
