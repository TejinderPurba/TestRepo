package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private BondRepository bondRepository;
    @Autowired
    private FutureRepository futureRepository;
    @Autowired
    private ExchangeTradedFundRepository exchangeTradedFundRepository;
    @Autowired
    private CashRepository cashRepository;

    @Override
    public Collection<Stock> getStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Collection<Cash> getCash() {
        return cashRepository.findAll();
    }

}
