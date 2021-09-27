package start;

import logic.Bus;
import logic.BusDepot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

        logger.info("Depot creation");
        BusDepot busDepot = new BusDepot(Arrays.asList(new Bus(1, 24, 89),
                new Bus(2, 30, 99),
                new Bus(3, 40, 66),
                new Bus(4, 25, 55),
                new Bus(5, 26, 44)));
        ExecutorService executors = Executors.newFixedThreadPool(5);
        busDepot.getBuses().forEach(executors::execute);
        executors.shutdown();
    }
}
