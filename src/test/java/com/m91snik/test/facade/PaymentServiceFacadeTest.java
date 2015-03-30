package com.m91snik.test.facade;

import com.m91snik.business.session.dto.Group;
import com.m91snik.business.session.dto.Session;
import com.m91snik.facade.PaymentServiceFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.Callable;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class PaymentServiceFacadeTest {

    @Autowired
    private PaymentServiceFacade paymentServiceFacade;

    @Test
    public void testCreditPayment() throws Exception {

        int parties = 3;
        Collection<Callable<Integer>> tasks = buildPaymentTasks(parties);
        Executors.newFixedThreadPool(parties).invokeAll(tasks);

    }

    private Collection<Callable<Integer>> buildPaymentTasks(int parties) throws InterruptedException,
            BrokenBarrierException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(parties);

        Collection<Callable<Integer>> tasks = new ArrayList<>();
        for (int i = 0; i < parties * 2; i++) {
            final int number = i;
            tasks.add(() ->
                      {
                          cyclicBarrier.await();
                          doCreditPayment(Arrays.asList(10L * (number + 1), 100L * (number + 1)), number);
                          return number;
                      }
            );
        }
        return tasks;
    }

    private void doCreditPayment(List<Long> amount, int userId) {
        Session session = new Session(userId + "", Group.USER);
        paymentServiceFacade.creditPayment(session, amount);
    }
}