package service.impl;

import exeption.RangeException;
import logic.Bus;
import logic.BusStop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.BusStopService;
import validator.CheckCorrectPassengerNumber;

import java.util.concurrent.TimeUnit;


public class BusStopServiceImpl implements BusStopService {

    private static Logger logger = LogManager.getLogger();
    private CheckCorrectPassengerNumber correctPassengerNumber = new CheckCorrectPassengerNumber();

    @Override
    public void busParking(Bus bus, BusStop busStop) throws RangeException {
        try {
            logger.info("The bus arrives at the stop, number bus: "+bus.getBusNumber());
            busStop.getSemaphore().acquire();
            logger.info("Bus at the stop, number bus: " +bus.getBusNumber());
            passengersGetOff(bus, busStop.getOutPassenger(), busStop);
            correctPassengerNumber.isCorrectRange(bus);
            passengerGenOn(bus, busStop.getEnteringPassenger(), busStop);
            correctPassengerNumber.isCorrectRange(bus);
            logger.info("The bus is waiting for passengers, number bus: " +bus.getBusNumber());
            logger.info(bus.getBusNumber() + "  " + Thread.currentThread().getName() + " passengers on the bus: " + bus.getPassengers());
            TimeUnit.SECONDS.sleep(busStop.getTimeStop());
            logger.info("The bus left, number bus: " +bus.getBusNumber());
            busStop.getSemaphore().release();
        } catch (RangeException e) {
            logger.error("Incorrect number of passengers");
            throw new RangeException();
        } catch (InterruptedException e) {
            logger.error("Interrupted exception ");
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void passengersGetOff(Bus bus, int passenger, BusStop busStop) {
        bus.setPassengers(bus.getPassengers() - passenger);
    }

    @Override
    public int passengerGenOn(Bus bus, int passenger, BusStop busStop) {
        bus.setPassengers(bus.getPassengers() + passenger);
        return bus.getPassengers() + passenger;
    }
}
