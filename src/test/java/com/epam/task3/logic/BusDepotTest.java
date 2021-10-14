package com.epam.task3.logic;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BusDepotTest {

    private static final BusDepot BUS_DEPOT = BusDepot.getInstance(List.of(new Bus(2,3,8)));

    @Test
    public void testGetInstanceShouldReturnSameObjectWhenInstanceAlreadyCreated() {
        BusDepot actualCompany;
        actualCompany = BusDepot.getInstance(List.of(new Bus(2,3,8)));
        Assert.assertEquals(BUS_DEPOT, actualCompany);
    }

}