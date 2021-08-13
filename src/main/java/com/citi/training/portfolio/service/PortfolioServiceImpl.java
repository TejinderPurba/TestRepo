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
    public Collection<Stock> getAllStocks() {
        return stockRepository.findAll();
    }
    @Override
    public Collection<Stock> getStocksBySymbol(String symbol) { return stockRepository.findBySymbol(symbol); }
    @Override
    public Collection<Stock> getStocksByName(String name) { return stockRepository.findByName(name); }
    @Override
    public Collection<Stock> getStocksByType(int type) { return stockRepository.findByTransactionType(type); }

    @Override
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds() { return exchangeTradedFundRepository.findAll(); }

    @Override
    public Collection<Cash> getAllCash() { return cashRepository.findAll(); }

    @Override
    public double dummyCurrentMarketValue(String symbol) {
        return 52.3;
    }
    @Override
    public double getInvestmentValue() {
        Collection<Stock> stocksTotal = stockRepository.getLatestStocks();
        double investmentValue = 0;
        for(Stock stock: stocksTotal) {
            investmentValue += (stock.getTotalQuantity() * dummyCurrentMarketValue(stock.getSymbol()));
        }

        Collection<ExchangeTradedFund> exchangeTradedFundTotal = exchangeTradedFundRepository.getLatestExchangeTradedFunds();
        for(ExchangeTradedFund exchangeTradedFund: exchangeTradedFundTotal) {
            investmentValue += (exchangeTradedFund.getTotalQuantity() * dummyCurrentMarketValue(exchangeTradedFund.getSymbol()));
        }
        return investmentValue;
    }
    @Override
    public double getCashValue() {
        Collection<Cash> cashTotal = cashRepository.getLatestCashBalances();
        double cashValue = 0;
        for(Cash cash: cashTotal) {
            cashValue += cash.getBalance();
        }
        return cashValue;
    }
    @Override
    public double[] getNetWorth() {
        double[] netWorth = {getInvestmentValue(), getCashValue(), getInvestmentValue() + getCashValue()};
        return netWorth;
    }
}
