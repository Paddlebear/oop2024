package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Vehicle extends Transport{
    
    protected int riteni;

    public Vehicle(String id, float consumption, int tankSize, int riteni) {
        super(id, consumption, tankSize);
        this.riteni = riteni;
    }

    @Override
    public String move(Road road) {
        if (road.getClass() != Road.class) {
            return "Cannot drive on " + road;
        }
        return super.move(road).replace("moving", "driving") + " with " + riteni + " wheels";
    }
}
