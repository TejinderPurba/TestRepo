package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import java.util.Collection;

public interface PortfolioService {
    /**
     * Get all stocks in the database.
     * @return Collection of Stocks with all database items.
     */
    public Collection<Stock> getAllStocks();

    /**
     * Get all stocks in the database by symbol.
     * @param symbol the symbol to use in the stock lookup.
     * @return Collection of Stocks with all database items by symbol.
     */
    public Collection<Stock> getStocksBySymbol(String symbol);

    /**
     * Get all stocks in the database by symbol.
     * @param name the name to use in the stock lookup.
     * @return Collection of Stocks with all database items by name.
     */
    public Collection<Stock> getStocksByName(String name);

    /**
     * Get all stocks in the database by type.
     * @param type the type to use in the stock lookup.
     * @return Collection of Stocks with all database items by type.
     */
    public Collection<Stock> getStocksByType(int type);

    /**
     * Add a new stock to the database.
     * @param stock the stock to be added to the database.
     */
    public void buyStock(Stock stock);

    /**
     * Sells a stock from the database.
     * @param stock the stock to be sold to the database.
     */
    public void sellStock(Stock stock);

    /**
     * Get all ETFs in the database.
     * @return Collection of ETFs with all database items.
     */
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds();

    /**
     * Get all cash accounts in the database.
     * @return Collection of cash accounts with all database items.
     */
    public Collection<Cash> getAllCash();

    /**
     * A dummy value representing the current market value of an investment.
     * @param symbol the symbol to use in the investment lookup.
     * @return A double representing the current market value of the investment.
     */
    public double dummyCurrentMarketValue(String symbol);

    /**
     * Gets the current value of all the investments in the database.
     * @return A double representing the total market value of all investments.
     */
    public double getInvestmentValue();

    /**
     * Gets the current value of all cash accounts in the database.
     * @return A double representing the total cash value of all cash accounts.
     */
    public double getCashValue();

    /**
     * Combines the investment and cash values to provide an overall net-worth.
     * @return Double array representing the investment, cash account, and overall net-worth
     */
    public double[] getNetWorth();
}