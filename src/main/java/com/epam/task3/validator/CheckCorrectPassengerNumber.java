package com.epam.task3.validator;

import com.epam.task3.exeption.RangeException;
import com.epam.task3.logic.Bus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckCorrectPassengerNumber {

    private static Logger logger = LogManager.getLogger();

    public boolean isCorrectRange(Bus bus) throws RangeException {

        byte minPassengers = 0;
        if (bus.getMaxPassengers() >= bus.getPassengers() && minPassengers <= bus.getPassengers()) {
            return true;
        } else {
            logger.error("Incorrect number of passengers for this bus: " + bus.getBusId());
            throw new RangeException();
        }
    }
}
