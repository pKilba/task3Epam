package logic;

import service.BusStopService;
import service.impl.BusStopServiceImpl;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Bus implements Runnable {
    //private static Logger logger = LogManager.getLogger();
    public static AtomicInteger busId = new AtomicInteger(0);
    private int busNumber;
    private int nextStop;
    private int passengers;
    private int maxPassengers;

    public Bus(int busNumber, int passengers, int maxPassengers) {
        this.busNumber = busNumber;
        this.passengers = passengers;
        this.maxPassengers = maxPassengers;
    }

    public AtomicInteger getBusId() {
        return busId;
    }

    public void setBusId(AtomicInteger busId) {
        this.busId = busId;
    }

    public int getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getNextStop() {
        return nextStop;
    }

    public void setNextStop(int nextStop) {
        this.nextStop = nextStop;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void openTheDoorForNumberPassenger(int numberPassenger) {

    }

    @Override
    public void run() {
        System.out.println("хуйня на " + busId);
        RoadMap roadMap = RoadMap.getInstance(Arrays.asList(
                new BusStop("1", 1, new AtomicInteger(1), 2, 3),
                new BusStop("2", 1, new AtomicInteger(2), 4, 5)));
        int lengthBusStop = roadMap.getBusStops().size();

        for (; nextStop < lengthBusStop; nextStop++) {
            BusStop busStop = roadMap.getNextBusStop(nextStop);
            BusStopService busStopService = new BusStopServiceImpl();
            busStopService.busParking(this, busStop);
//             busStop.busParking(this);
        }
    }
}
