package com.epam.task3.logic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class BusDepotTest {

    private static final BusDepot BUS_DEPOT = BusDepot.getInstance(List.of(new Bus(2,3,8)));

    @Test
    @DisplayName("Should not create another Bus Depot")
    public void testCheckingSingleBusDepot() {
        BusDepot actualCompany;
        actualCompany = BusDepot.getInstance(List.of(new Bus(2,3,8)));
        Assert.assertEquals(BUS_DEPOT, actualCompany);
    }

}