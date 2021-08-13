package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import java.util.Collection;

public interface PortfolioService {
    public Collection<Stock> getStocks();

    public Collection<Cash> getCash();
}