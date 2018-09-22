package com.miglazer.stocklending.service;

import com.miglazer.stocklending.data.Equity;
import com.miglazer.stocklending.repository.StockLendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockLendingService {

    @Autowired
    private StockLendingRepository stockLendingRepository;

    public List<Equity> equities(){
        return stockLendingRepository.equities();
    }
}
