package start;

import logic.Bus;
import logic.BusDepot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        BusDepot busDepot = new BusDepot(Arrays.asList(new Bus(1, 2, 3),
                new Bus(2, 3, 4),
                new Bus(3, 4, 5),
                new Bus(4, 5, 6),
                new Bus(5, 6, 7)));

        ExecutorService executors = Executors.newFixedThreadPool(5);
//       ArrayList<Bus> list = new ArrayList(Arrays.asList(new Bus(1, 2, 3),
//               new Bus(2, 3, 4),
//               new Bus(3, 4, 5),
//               new Bus(4, 5, 6),
//               new Bus(5, 6, 7)));
       busDepot.getBuses().forEach(executors::execute);

    }
}
