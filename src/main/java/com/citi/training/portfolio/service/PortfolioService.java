package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

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
     * @param stock the stock to be sold in the database.
     */
    public void sellStock(Stock stock);

    /**
     * Get all ETFs in the database.
     * @return Collection of ETFs with all database items.
     */
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds();

    /**
     * Get all exchange traded funds in the database by symbol.
     * @param symbol the symbol to use in the exchange traded funds lookup.
     * @return Collection of ExchangeTradedFunds with all database items by symbol.
     */
    public Collection<ExchangeTradedFund> getExchangeTradedFundsBySymbol(String symbol);

    /**
     * Get all exchange traded funds in the database by symbol.
     * @param name the name to use in the exchange traded funds lookup.
     * @return Collection of ExchangeTradedFunds with all database items by name.
     */
    public Collection<ExchangeTradedFund> getExchangeTradedFundsByName(String name);

    /**
     * Get all exchange traded funds in the database by type.
     * @param type the type to use in the exchange traded funds lookup.
     * @return Collection of ExchangeTradedFunds with all database items by type.
     */
    public Collection<ExchangeTradedFund> getExchangeTradedFundsByType(int type);

    /**
     * Add a new exchange traded fund to the database.
     * @param exchangeTradedFund the exchange traded fund to be added to the database.
     */
    public void buyExchangeTradedFund(ExchangeTradedFund exchangeTradedFund);

    /**
     * Sells a exchange traded fund from the database.
     * @param exchangeTradedFund the exchange traded fund to be sold in the database.
     */
    public void sellExchangeTradedFund(ExchangeTradedFund exchangeTradedFund);

    /**
     * Get all cash accounts in the database.
     * @return Collection of cash accounts with all database items.
     */
    public Collection<Cash> getAllCash();

    /**
     * Get all cash in the database by transaction type.
     * @param type the transaction type to use in the cash lookup.
     * @return Collection of Cash with all database items by transaction type.
     */
    public Collection<Cash> getCashByTransactionType(int type);

    /**
     * Get all cash in the database by account type.
     * @param type the account type to use in the cash lookup.
     * @return Collection of Cash with all database items by account type.
     */
    public Collection<Cash> getCashByAccountType(int type);

    /**
     * Get all cash in the database by account number.
     * @param account the account number to use in the cash lookup.
     * @return Collection of Cash with all database items by account number.
     */
    public Collection<Cash> getCashByAccountNumber(int account);

    /**
     * Get all cash in the database by financial institution.
     * @param institution the institution name to use in the cash lookup.
     * @return Collection of Cash with all database items by financial institution.
     */
    public Collection<Cash> getCashByFinancialInstitution(String institution);

    /**
     * Deposit a cash amount to the database.
     * @param cash the cash to be added to the database.
     */
    public void depositCash(Cash cash);

    /**
     * Withdraw a cash amount from the database.
     * @param cash the cash to be withdrawn in the database.
     */
    public void withdrawCash(Cash cash);

    /**
     * Get all bonds in the database.
     * @return Collection of bonds with all database items.
     */
    public Collection<Bond> getAllBonds();

    /**
     * Get all bonds in the database by issuer.
     * @param issuer the issuer to use in the bond lookup.
     * @return Collection of bonds with all database items by issuer.
     */
    public Collection<Bond> getBondsByIssuer(String issuer);

    /**
     * Get all bonds in the database by name.
     * @param name the name to use in the bond lookup.
     * @return Collection of bonds with all database items by bond name.
     */
    public Collection<Bond> getBondsByName(String name);

    /**
     * Get all bonds in the database by bond type.
     * @param bondType the bond type to use in the cash lookup.
     * @return Collection of bonds with all database items by bond type.
     */
    public Collection<Bond> getBondsByBondType(String bondType);

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

    /**
     * A dummy value representing the current market mover value of an investment.
     * @param symbol the symbol to use in the investment lookup.
     * @return A double representing the current market mover value of the investment in percents.
     */
    public Double dummyCurrentMarketMover(String symbol);

    /**
     * Generates the market mover data based on current investments.
     * @return A sorted indicating market values of each investment.
     */
    public SortedMap getMarketMovers();

    /**
     * Add a new bond to the database.
     * @param bond the bond to be added to the database.
     */
    public void buyBond(Bond bond);

    /**
     * Sells a bond from the database.
     * @param bondName the bond to be sold in the database.
     */
    public void sellBond(String bondName);

}