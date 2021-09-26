package logic;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BusStop {

    private String name;
    private int busesMax;
    private AtomicInteger currentBuses;
    private AtomicInteger passengers;
    private int timeStop;
    //сделть штуку про посадку додиков чтобы садились по одному
    //private Lock passengersLock = new ReentrantLock(true);
    private Semaphore semaphore;
    private int enteringPassenger;
    private int outPassenger;

    public int getOutPassenger() {
        return this.outPassenger;
    }

    public BusStop(String name, int busesMax,
                   AtomicInteger passengers, int enteringPassenger,
                   int outPassenger) {
        this.name = name;
        this.busesMax = busesMax;
        this.passengers = passengers;
        this.semaphore = new Semaphore(busesMax, true);
        this.enteringPassenger = enteringPassenger;
        this.outPassenger = outPassenger;
    }

    public void setEnteringPassenger(int enteringPassenger) {
        this.enteringPassenger = enteringPassenger;
    }

    public void setOutPassenger(int outPassenger) {
        this.outPassenger = outPassenger;
    }

    public int getEnteringPassenger() {
        return enteringPassenger;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBusesMax() {
        return busesMax;
    }

    public void setBusesMax(int busesMax) {
        this.busesMax = busesMax;
    }

    public AtomicInteger getCurrentBuses() {
        return currentBuses;
    }

    public void setCurrentBuses(AtomicInteger currentBuses) {
        this.currentBuses = currentBuses;
    }

    public AtomicInteger getPassengers() {
        return passengers;
    }

    public void setPassengers(AtomicInteger passengers) {
        this.passengers = passengers;
    }

    public int getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(int timeStop) {
        this.timeStop = timeStop;
    }

    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


//    public void busParking(Bus bus) {
//        try {
//            System.out.println("автобус проверяет не занята ли остановка");
//            semaphore.acquire();
//            System.out.println("автобус на остановке");
//            //  logger.log(Level.INFO, String.format("Bus id = %d has been stopped... on station name = %s. Passengers on station = %d in bus %d", bus.getBusId(), name, passengers.get(), bus.getPassengers()));
//            passengersGetOff(bus, outPassenger);
//            passengerGenOn(bus, enteringPassenger);
//
//
//            System.out.println("автобус ждёт пассажиров");
//            System.out.println(this.name + "  " + Thread.currentThread().getName() + " зашло и вышло , текущее число на остановке " +
//                    enteringPassenger + " " + outPassenger + "  " + this.passengers.get());
//            //выйти и зайти пассажирам
//            TimeUnit.SECONDS.sleep(timeStop);
//            System.out.println("автобус уехал");
//            // logger.log(Level.INFO, String.format("Bus id = %d has been driven to next station...Passengers on station = %d in bus %d", bus.getBusId(), passengers.get(), bus.getPassengers()));
//            semaphore.release();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

//    public void passengersGetOff(Bus bus, int passenger) {
//        //мб занулить кол-во пассажиров
//        this.passengers.set(passenger + passengers.get());
//    }
//
//    public int passengerGenOn(Bus bus, int passenger) {
//        //изменить
//        passengers.set(passengers.get() - passenger);
//        return bus.getPassengers() + passenger;
//        //provwerits na maks passazirov;
//    }

}



