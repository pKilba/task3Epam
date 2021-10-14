package com.epam.task3.logic;

import com.epam.task3.view.BusRunningView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.task3.service.BusStopService;
import com.epam.task3.service.impl.BusStopServiceImpl;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Bus implements Runnable {

    private static final BusRunningView BUS_RUNNING = new BusRunningView();
    private static Logger logger = LogManager.getLogger();
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

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        Bus.logger = logger;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bus bus = (Bus) o;
        return busNumber == bus.busNumber && nextStop == bus.nextStop && passengers == bus.passengers && maxPassengers == bus.maxPassengers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(busNumber, nextStop, passengers, maxPassengers);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bus{");
        sb.append("busNumber=").append(busNumber);
        sb.append(", nextStop=").append(nextStop);
        sb.append(", passengers=").append(passengers);
        sb.append(", maxPassengers=").append(maxPassengers);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void run() {
        logger.info("Bus waiting, id bus: " + busId.getAndAdd(1));
        BUS_RUNNING.WaitBus(this);
        RoadMap roadMap = new RoadMap(Arrays.asList(
                new BusStop("Fist Stop", 3, new AtomicInteger(1), 2, 3),
                new BusStop("Second Stop", 1, new AtomicInteger(2), 4, 5)));
        int lengthBusStops = roadMap.getBusStops().size();
        for (; nextStop < lengthBusStops; nextStop++) {
            BusStop busStop = roadMap.getNextBusStop(nextStop);
            BusStopService busStopService = new BusStopServiceImpl();
            try {
                busStopService.busParking(this, busStop);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                logger.error("Bus parking exceptional");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
