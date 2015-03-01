package com.m91snik.test.business.service.impl;

import com.m91snik.business.service.PaymentService;
import com.m91snik.business.session.SessionService;
import com.m91snik.business.session.dto.Group;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class PaymentServiceImplTest {


    @Autowired
    private PaymentService paymentService;
    @Autowired
    private SessionService sessionService;

    @Test
    public void testDoCredit() throws Exception {
        sessionService.createSession("1", Group.USER);
        paymentService.doCredit(10);
    }

    @Test(expected = IllegalStateException.class)
    public void testDoCreditPermissionRestricted() throws Exception {
        sessionService.createSession("1", Group.ANONYMOUS);
        paymentService.doCredit(10);
    }

    @Test
    public void testDoCreditPayment() throws Exception {
        sessionService.createSession("1", Group.USER);
        paymentService.doCredit(10);
        paymentService.doCredit(0);
    }
}