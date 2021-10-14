package com.epam.task3.logic;

import java.util.List;
import java.util.Objects;

public class RoadMap {

    private List<BusStop> busStops;

    RoadMap(List<BusStop> busStops) {
        this.busStops = busStops;
    }

    public List<BusStop> getBusStops() {
        return busStops;
    }

    public void setBusStops(List<BusStop> busStops) {
        this.busStops = busStops;
    }

    public BusStop getNextBusStop(int i) {
        return busStops.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoadMap roadMap = (RoadMap) o;
        return Objects.equals(busStops, roadMap.busStops);
    }

    @Override
    public int hashCode() {
        return Objects.hash(busStops);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RoadMap{");
        sb.append("busStops=").append(busStops);
        sb.append('}');
        return sb.toString();
    }
}
