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
import java.util.List;
import java.util.concurrent.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context.xml")
public class PaymentServiceFacadeTest {

    @Autowired
    private PaymentServiceFacade paymentServiceFacade;

    @Test
    public void testCreditPayment() throws Exception {

        int parties = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(parties);
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(parties);

        List<Future<Integer>> futures = new ArrayList<Future<Integer>>();
        for (int i = 0; i < parties; i++) {
            final int number = i;
            Future<Integer> submit = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    cyclicBarrier.await();
                    doCreditPayment(100 * (number + 1), number);
                    return number;
                }
            });
            futures.add(submit);
        }
        for (Future<Integer> future : futures) {
            future.get();
        }

    }

    private void doCreditPayment(long amount, int userId) {
        Session session = new Session(userId + "", Group.USER);
        paymentServiceFacade.creditPayment(session, amount);
    }
}