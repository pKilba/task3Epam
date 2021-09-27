package service;

import logic.Bus;
import logic.BusStop;

public interface BusStopService {

    void busParking(Bus bus, BusStop busStop) throws Exception;

    void passengersGetOff(Bus bus, int passenger, BusStop busStop);

    int passengerGenOn(Bus bus, int passenger, BusStop busStop);

}
