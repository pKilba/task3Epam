package logic;

import java.util.List;

public class RoadMap {

    private List<BusStop> busStops;
    private static RoadMap instance;

    private RoadMap(List<BusStop> busStops) {
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

    public static RoadMap getInstance(List<BusStop> busStops) {
        //zamena na optional
        if (instance == null) {
            instance = new RoadMap(busStops);
        }
        return instance;
    }

}
