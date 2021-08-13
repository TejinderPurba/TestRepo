package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import java.util.Collection;

public interface PortfolioService {
    public Collection<Stock> getAllStocks();
    public Collection<Stock> getStocksBySymbol(String symbol);
    public Collection<Stock> getStocksByName(String name);
    public Collection<Stock> getStocksByType(int type);

    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds();

    public Collection<Cash> getAllCash();

    public double dummyCurrentMarketValue(String symbol);
    public double getInvestmentValue();
    public double getCashValue();
    public double[] getNetWorth();
}