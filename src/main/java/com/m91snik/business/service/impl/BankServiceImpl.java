package com.m91snik.business.service.impl;

import com.m91snik.annotation.UnsafeOperation;
import com.m91snik.business.service.BankService;
import org.springframework.stereotype.Service;

/**
 * Created by nikolay.garbuzov on 25.02.15.
 */
@Service
public class BankServiceImpl implements BankService {

    @Override
    @UnsafeOperation
    public void transferMoney(int sum) {

    }
}
