package com.m91snik.business.service;


import com.m91snik.business.exception.BusinessException;

import java.util.List;

public interface PriceService {

    void validatePrices(List<Integer> prices) throws BusinessException;

    double calculateAvgPrice(List<Integer> prices);
}
