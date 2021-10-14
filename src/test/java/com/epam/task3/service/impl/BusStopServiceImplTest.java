package com.epam.task3.service.impl;

import com.epam.task3.logic.Bus;
import com.epam.task3.logic.BusStop;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;


public class BusStopServiceImplTest {

    private static final Bus BUS = new Bus(1, 10, 20);
    private static final BusStop BUS_STOP = new BusStop("Fist Stop", 3, new AtomicInteger(1), 2, 3);

    @Test
    @DisplayName("Should return correct number about passenger bus")
    public void passengersGetOff() {
        int passengerGetOut = BUS_STOP.getOutPassenger();
        int expResult = 7;
        int result = BUS.getPassengers() - passengerGetOut;
        assertEquals(expResult, result);
    }

    @Test
    @DisplayName("Should return correct number about passenger bus")
    public void passengerGenOn() {
        int passengersEntering = BUS_STOP.getEnteringPassenger();
        int expResult = 12;
        int result = BUS.getPassengers() + passengersEntering;
        assertEquals(expResult, result);

    }
}