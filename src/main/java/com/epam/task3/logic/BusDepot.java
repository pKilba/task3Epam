package com.epam.task3.logic;

import java.util.List;
import java.util.Objects;

public class BusDepot {

    private static BusDepot instance;
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

    public static BusDepot getInstance() {
        return instance;
    }

    public static void setInstance(BusDepot instance) {
        BusDepot.instance = instance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusDepot busDepot = (BusDepot) o;
        return Objects.equals(buses, busDepot.buses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buses);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusDepot{");
        sb.append("buses=").append(buses);
        sb.append('}');
        return sb.toString();
    }
}
