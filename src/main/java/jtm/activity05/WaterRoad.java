package jtm.activity05;

import jtm.activity04.Road;

public class WaterRoad extends Road {

    //(string, string, int) konstruktors
    public WaterRoad(String from, String to, int distance) {
        super(from, to, distance);
    }

    //() konstruktors
    public WaterRoad(){
        super();
    }

    //tostring() override
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + super.toString();
    }
}