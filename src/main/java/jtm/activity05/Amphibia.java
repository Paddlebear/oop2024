package jtm.activity05;

import jtm.activity04.Road;

public class Amphibia extends Vehicle{
    
    private byte buras;
    // private int riteni;
    // private String id;
    // private float consumption;
    // private int tankSize;

    public Amphibia(String id, float consumption, int tankSize, byte buras, int riteni) {
        super(id, consumption, tankSize, riteni);
        this.buras = buras;
    }

    @Override
    public String move(Road road) {
        if (road.getClass() == WaterRoad.class) {
            return getType() + " is sailing on " + road + " with " + buras + " sails";
        }
        return super.move(road);
    }

}
