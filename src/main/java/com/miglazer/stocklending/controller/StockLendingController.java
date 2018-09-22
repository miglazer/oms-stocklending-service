package com.miglazer.stocklending.controller;

import com.miglazer.stocklending.data.Equity;
import com.miglazer.stocklending.repository.StockLendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/securities")
public class StockLendingController {

    @Autowired
    private StockLendingRepository stockLendingRepository;

    @GetMapping(path = "/equities")
    public List<Equity> equities(){
        return stockLendingRepository.equities();
    }

}
