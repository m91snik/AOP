/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.business.service;


import java.util.List;

public interface PaymentService {

    void doCredit(List<Long> amounts);
}
