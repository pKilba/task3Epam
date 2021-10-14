package com.epam.task3.view;

import com.epam.task3.logic.Bus;

public class BusRunningView {

    public void WaitBus(Bus bus) {
        System.out.println("Bus went, number bus " + bus.getBusNumber());
    }

}
