package com.epam.task3.logic;

import java.util.List;

public class BusDepot {


    private  static  BusDepot instance;
    private List<Bus> buses;

    BusDepot(List<Bus> buses) {
        this.buses = buses;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }

    public static BusDepot getInstance(List<Bus> buses) {
        if (instance == null) {
            instance = new BusDepot(buses);
        }
        return instance;
    }

}
