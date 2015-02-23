/**
 * Created by nikolay.garbuzov on 23.02.15.
 */
package com.m91snik.business.service.impl;

import com.m91snik.annotation.SessionRequired;
import com.m91snik.business.service.PaymentService;
import com.m91snik.business.session.dto.Group;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    @SessionRequired(group = {Group.USER, Group.OPERATOR})
    public void doCredit(Integer amount) {
        //TODO: do credit payment
    }
}
