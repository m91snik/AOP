package com.m91snik.test.facade;

import com.m91snik.business.session.dto.Group;
import com.m91snik.business.session.dto.Session;
import com.m91snik.facade.PaymentServiceFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class PaymentServiceFacadeTest {

    @Autowired
    private PaymentServiceFacade paymentServiceFacade;

    @Test
    public void testCreditPayment() throws Exception {
        doCreditPayment(100);
        doCreditPayment(200);
    }

    private void doCreditPayment(long amount) {
        Session session = new Session("user1", Group.USER);
        paymentServiceFacade.creditPayment(session, amount);
    }
}