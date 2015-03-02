/**
 * Created by m91snik on 22.02.15.
 */
package com.m91snik.business.service.impl;

import com.m91snik.contract.ExceptionProcessingRequired;
import com.m91snik.business.exception.BusinessException;
import com.m91snik.business.exception.ImportantException;
import com.m91snik.business.service.PriceService;
import org.springframework.stereotype.Service;

import java.util.IntSummaryStatistics;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Override
    @ExceptionProcessingRequired
    public void validatePrices(List<Integer> prices) throws BusinessException {
        if (prices == null) {
            throw new IllegalArgumentException("Prices are null");
        }
        IntSummaryStatistics stats = getIntSummaryStatistics(prices);
        long sum = stats.getSum();
        if (sum > 100) {
            throw new ImportantException("Prices are too high");
        }
    }

    private IntSummaryStatistics getIntSummaryStatistics(List<Integer> prices) {
        return prices.stream().mapToInt((x) -> x).summaryStatistics();
    }

    @Override
    public final double calculateAvgPrice(List<Integer> prices) {
        //logging
        IntSummaryStatistics stats = getIntSummaryStatistics(prices);
        double average = stats.getAverage();
        //logging
        return average;
    }
}
