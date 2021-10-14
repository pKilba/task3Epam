package com.epam.task3.logic;

import java.util.List;

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



}
