package com.epam.task3.service;

import com.epam.task3.logic.Bus;
import com.epam.task3.logic.BusStop;

public interface BusStopService {

    void busParking(Bus bus, BusStop busStop) throws Exception;

    void passengersGetOff(Bus bus, int passenger, BusStop busStop);

    int passengerGenOn(Bus bus, int passenger, BusStop busStop);

}
