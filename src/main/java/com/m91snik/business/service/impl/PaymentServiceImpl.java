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

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private BankService bankService;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    @SessionRequired(group = {Group.USER, Group.OPERATOR})
    public void doCredit(List<Long> amounts) {
        amounts.stream().forEach(amount -> bankService.transferMoney(amount));

//        //NOTE: threads are not supported by cflow because it uses ThreadLocal to track flow
//        Collection<Callable<Long>> tasks = new ArrayList<>();
//        amounts.stream().forEach(amount -> tasks.add(() -> bankService.transferMoney(amount)));
//        try {
//            executorService.invokeAll(tasks);
//        } catch (InterruptedException e) {
//            throw new IllegalStateException(e);
//        }
    }
}
