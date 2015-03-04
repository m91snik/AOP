/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.business.service.impl;

import com.m91snik.business.service.BankService;
import com.m91snik.business.service.PaymentService;
import com.m91snik.business.session.dto.Group;
import com.m91snik.contract.SessionRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private BankService bankService;

    @Override
    @SessionRequired(group = {Group.USER, Group.OPERATOR})
    public void doCredit(List<Long> amounts) {
        for (Long amount : amounts) {
            bankService.transferMoney(amount);
        }

        //NOTE: threads are not supported by cflow because it uses ThreadLocal to track flow
//        Collection<Callable<Long>> tasks = new ArrayList<>();
//        for (final Long amount : amounts) {
//            tasks.add(() -> bankService.transferMoney(amount));
//        }
//        ExecutorService executorService = Executors.newFixedThreadPool(10);
//        try {
//            List<Future<Long>> futures = executorService.invokeAll(tasks);
//            for (Future<Long> future : futures) {
//                future.get();
//            }
//
//        } catch (InterruptedException | ExecutionException e) {
//            throw new IllegalStateException(e);
//        }
    }
}
