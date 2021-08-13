package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import java.util.Collection;

public interface PortfolioService {
    public Collection<Stock> getAllStocks();

    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds();

    public Collection<Cash> getAllCash();

    public double dummyCurrentMarketValue(String symbol);

    public double getInvestmentValue();

    public double getCashValue();

    public double[] getNetWorth();
}