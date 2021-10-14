package com.epam.task3.service.impl;

import com.epam.task3.exeption.RangeException;
import com.epam.task3.logic.Bus;
import com.epam.task3.logic.BusStop;
import com.epam.task3.view.BusStopServiceView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.task3.service.BusStopService;
import com.epam.task3.validator.CheckCorrectPassengerNumber;

import java.util.concurrent.TimeUnit;


public class BusStopServiceImpl implements BusStopService {

    private static final BusStopServiceView BUS_STOP_SERVICE_VIEW = new BusStopServiceView();
    private static Logger logger = LogManager.getLogger();
    private CheckCorrectPassengerNumber correctPassengerNumber = new CheckCorrectPassengerNumber();

    @Override
    public void busParking(Bus bus, BusStop busStop) throws RangeException, InterruptedException {
        BUS_STOP_SERVICE_VIEW.ArriveStop(bus,busStop);
        logger.info("The bus arrives at the stop, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
        busStop.getSemaphore().acquire();
        BUS_STOP_SERVICE_VIEW.StayAtStop(bus,busStop);
        logger.info("Bus at the stop, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
        passengersGetOff(bus, busStop.getOutPassenger(), busStop);
        passengerGenOn(bus, busStop.getEnteringPassenger(), busStop);
        correctPassengerNumber.isCorrectRange(bus);
        logger.info("The bus is waiting for passengers, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
        logger.info(bus.getBusNumber() + "  " + Thread.currentThread().getName() + " passengers on the bus: " + bus.getPassengers());
        TimeUnit.SECONDS.sleep(busStop.getTimeStop());
        BUS_STOP_SERVICE_VIEW.LeftBusStop(bus,busStop);
        logger.info("The bus left, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
        busStop.getSemaphore().release();
    }

    @Override
    public int passengersGetOff(Bus bus, int passenger, BusStop busStop) throws RangeException {
        int result = bus.getPassengers() - passenger;
        bus.setPassengers(result);
        correctPassengerNumber.isCorrectRange(bus);
        return result;
    }

    @Override
    public int passengerGenOn(Bus bus, int passenger, BusStop busStop) throws RangeException {
        int result = bus.getPassengers() + passenger;
        bus.setPassengers(result);
        correctPassengerNumber.isCorrectRange(bus);
        return result;
    }
}
