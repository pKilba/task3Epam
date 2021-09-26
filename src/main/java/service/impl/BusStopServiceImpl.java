package service.impl;

import logic.Bus;
import logic.BusStop;
import service.BusStopService;

import java.util.concurrent.TimeUnit;

public class BusStopServiceImpl implements BusStopService {
    @Override
    public void busParking(Bus bus, BusStop busStop) {
        try {
            System.out.println("автобус проверяет не занята ли остановка");
            busStop.getSemaphore().acquire();
            System.out.println("автобус на остановке");
            //  logger.log(Level.INFO, String.format("Bus id = %d has been stopped... on station name = %s. Passengers on station = %d in bus %d", bus.getBusId(), name, passengers.get(), bus.getPassengers()));
            passengersGetOff(bus,busStop.getOutPassenger(),busStop);
            passengerGenOn(bus, busStop.getEnteringPassenger(),busStop);

            System.out.println("автобус ждёт пассажиров");
            System.out.println(bus.getBusNumber() + "  " + Thread.currentThread().getName() + " зашло и вышло , текущее число в автобсе " +
                    busStop.getEnteringPassenger()+ " " + busStop.getOutPassenger() + "  " + bus.getPassengers());
            //выйти и зайти пассажирам
            TimeUnit.SECONDS.sleep(busStop.getTimeStop());
            System.out.println("автобус уехал");
            // logger.log(Level.INFO, String.format("Bus id = %d has been driven to next station...Passengers on station = %d in bus %d", bus.getBusId(), passengers.get(), bus.getPassengers()));
            busStop.getSemaphore().release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void passengersGetOff(Bus bus, int passenger,BusStop busStop) {
        //мб занулить кол-во пассажиров
   bus.setPassengers(bus.getPassengers()-passenger);
    //   busStop.getPassengers().set(busStop.getPassengers().addAndGet(passenger) );
    }

    @Override
    public int passengerGenOn(Bus bus, int passenger,BusStop busStop) {
      bus.setPassengers(bus.getPassengers()+passenger);
       return bus.getPassengers()+passenger;
        // busStop.getPassengers().set(busStop.getPassengers().addAndGet(- passenger) );
        //return bus.getPassengers() + passenger;
    }
}
