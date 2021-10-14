package com.epam.task3.logic;

import java.util.Objects;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class BusStop {

    private String name;
    private int busesMax;
    private AtomicInteger passengers;
    private int timeStop;
    private Semaphore semaphore;
    private int enteringPassenger;
    private int outPassenger;

    public BusStop(String name, int busesMax,
                   AtomicInteger passengers, int enteringPassenger,
                   int outPassenger) {
        this.name = name;
        this.busesMax = busesMax;
        this.passengers = passengers;
        this.semaphore = new Semaphore(busesMax, true);
        this.enteringPassenger = enteringPassenger;
        this.outPassenger = outPassenger;
    }

    public void setEnteringPassenger(int enteringPassenger) {
        this.enteringPassenger = enteringPassenger;
    }

    public void setOutPassenger(int outPassenger) {
        this.outPassenger = outPassenger;
    }

    public int getEnteringPassenger() {
        return enteringPassenger;
    }

    public int getOutPassenger() {
        return this.outPassenger;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBusesMax() {
        return busesMax;
    }

    public void setBusesMax(int busesMax) {
        this.busesMax = busesMax;
    }

    public AtomicInteger getPassengers() {
        return passengers;
    }

    public void setPassengers(AtomicInteger passengers) {
        this.passengers = passengers;
    }

    public int getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(int timeStop) {
        this.timeStop = timeStop;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusStop busStop = (BusStop) o;
        return busesMax == busStop.busesMax && timeStop == busStop.timeStop && enteringPassenger == busStop.enteringPassenger && outPassenger == busStop.outPassenger && Objects.equals(name, busStop.name) && Objects.equals(passengers, busStop.passengers) && Objects.equals(semaphore, busStop.semaphore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, busesMax, passengers, timeStop, semaphore, enteringPassenger, outPassenger);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BusStop{");
        sb.append("name='").append(name).append('\'');
        sb.append(", busesMax=").append(busesMax);
        sb.append(", passengers=").append(passengers);
        sb.append(", timeStop=").append(timeStop);
        sb.append(", semaphore=").append(semaphore);
        sb.append(", enteringPassenger=").append(enteringPassenger);
        sb.append(", outPassenger=").append(outPassenger);
        sb.append('}');
        return sb.toString();
    }
}



