package jtm.activity05;

import jtm.activity04.Road;
import jtm.activity04.Transport;

public class Ship extends Transport{
    
    protected byte sails;

    public Ship(String id, float consumption, int tankSize) {
        super(id, consumption, tankSize);
    }

    public Ship(String id, byte sails) {
        super(id, 0, 0);
        this.sails = sails;
    }

    @Override
    public String move(Road road) {
        return move(this, road);
    }

    static String move(Transport transport, Road road) {
        if (road.getClass() != WaterRoad.class) {
            return "Cannot sail on " + road;
        }
        if (transport instanceof Ship) {
            Ship ship = (Ship) transport;
            return ship.getType() + " is sailing on " + road + " with " + ship.sails + " sails";
        }
        return "ERROR: unknown transport type!";
    }
}
