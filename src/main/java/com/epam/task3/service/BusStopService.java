package com.epam.task3.service;

import com.epam.task3.exeption.RangeException;
import com.epam.task3.logic.Bus;
import com.epam.task3.logic.BusStop;

public interface BusStopService {

    void busParking(Bus bus, BusStop busStop) throws RangeException, InterruptedException;

    int passengersGetOff(Bus bus, int passenger, BusStop busStop) throws  RangeException;

    int passengerGenOn(Bus bus, int passenger, BusStop busStop) throws  RangeException;

}
