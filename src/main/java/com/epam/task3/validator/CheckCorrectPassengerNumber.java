package com.epam.task3.validator;

import com.epam.task3.exeption.RangeException;
import com.epam.task3.logic.Bus;

public class CheckCorrectPassengerNumber {

    public boolean isCorrectRange(Bus bus) throws RangeException {

        byte minPassengers = 0;
        if (bus.getMaxPassengers() >= bus.getPassengers() && minPassengers <= bus.getPassengers()) {
            return true;
        } else {
            throw new RangeException();
        }
    }
}
