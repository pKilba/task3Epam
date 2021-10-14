package com.epam.task3.view;

import com.epam.task3.logic.Bus;
import com.epam.task3.logic.BusStop;

public class BusStopServiceView {

    public void ArriveStop(Bus bus, BusStop busStop) {
        System.out.println("The bus arrives at the stop, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
    }

    public void StayAtStop(Bus bus, BusStop busStop) {
        System.out.println("Bus at the stop, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
    }

    public void LeftBusStop(Bus bus, BusStop busStop) {
        System.out.println("The bus left, number bus: " + bus.getBusNumber() + ", name stop: " + busStop.getName());
    }
}
