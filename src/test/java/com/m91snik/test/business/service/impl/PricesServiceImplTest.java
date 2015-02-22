package com.m91snik.test.business.service.impl;

import com.m91snik.business.exception.ImportantException;
import com.m91snik.business.service.PriceService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class PricesServiceImplTest {

    @Autowired
    private PriceService priceService;

    @Test
    public void testValidatePrices() throws Exception {
        priceService.validatePrices(Arrays.asList(100));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullValidatePrices() throws Exception {
        priceService.validatePrices(null);
    }

    @Test(expected = ImportantException.class)
    public void testOverflowValidatePrices() throws Exception {
        priceService.validatePrices(Arrays.asList(1000, 2000));
    }

    @Test
    public void testCalculateAvgPrice() throws Exception {
        double avg = priceService.calculateAvgPrice(Arrays.asList(100, 200));
        Assert.assertEquals(150.0, avg, 0);

    }
}