package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

import static java.util.Objects.isNull;

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

    /**
     * STOCK METHODS
     */
    @Override
    public Collection<Stock> getAllStocks() {
        return stockRepository.findAllSorted();
    }
    @Override
    public Collection<Stock> getStocksBySymbol(String symbol) { return stockRepository.findBySymbol(symbol); }
    @Override
    public Collection<Stock> getStocksByName(String name) { return stockRepository.findByName(name); }
    @Override
    public Collection<Stock> getStocksByType(int type) { return stockRepository.findByTransactionType(type); }
    @Override
    @Transactional
    public void buyStock(Stock stock) {
        Collection<Stock> recentTransactions = stockRepository.getLatestStockTransactionBySymbol(stock.getSymbol());
        if (recentTransactions.size() > 0) {
            Stock recentTransaction = recentTransactions.iterator().next();
            stock.setTotalQuantity(recentTransaction.getTotalQuantity() + stock.getQuantityAffected());
        }
        else stock.setTotalQuantity(stock.getQuantityAffected());
        stock.setTotalValue(stock.getTotalQuantity() * stock.getMarketValue());
        stockRepository.save(stock);
    }
    @Override
    @Transactional
    public void sellStock(Stock stock) {
        Collection<Stock> recentTransactions = stockRepository.getLatestStockTransactionBySymbol(stock.getSymbol());
        if (recentTransactions.size() > 0) {
            Stock recentTransaction = recentTransactions.iterator().next();
            if (stock.getQuantityAffected() <= recentTransaction.getTotalQuantity()) {
                stock.setTotalQuantity(recentTransaction.getTotalQuantity() - stock.getQuantityAffected());
                stock.setTotalValue(stock.getTotalQuantity() * stock.getMarketValue());
            }
            stockRepository.save(stock);
        }
    }

    /**
     * EXCHANGED TRADED FUNDS METHODS
     */
    @Override
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds() { return exchangeTradedFundRepository.findAllSorted(); }
    @Override
    public Collection<ExchangeTradedFund> getExchangeTradedFundsBySymbol(String symbol) { return exchangeTradedFundRepository.findBySymbol(symbol); }
    @Override
    public Collection<ExchangeTradedFund> getExchangeTradedFundsByName(String name) { return exchangeTradedFundRepository.findByName(name); }
    @Override
    public Collection<ExchangeTradedFund> getExchangeTradedFundsByType(int type) { return exchangeTradedFundRepository.findByTransactionType(type); }
    @Override
    @Transactional
    public void buyExchangeTradedFund(ExchangeTradedFund exchangeTradedFund) {
        Collection<ExchangeTradedFund> recentTransactions = exchangeTradedFundRepository.getLatestExchangeTradedFundTransactionBySymbol(exchangeTradedFund.getSymbol());
        if (recentTransactions.size() > 0) {
            ExchangeTradedFund recentTransaction = recentTransactions.iterator().next();
            exchangeTradedFund.setTotalQuantity(recentTransaction.getTotalQuantity() + exchangeTradedFund.getQuantityAffected());
        }
        else exchangeTradedFund.setTotalQuantity(exchangeTradedFund.getQuantityAffected());
        exchangeTradedFund.setTotalValue(exchangeTradedFund.getTotalQuantity() * exchangeTradedFund.getMarketValue());
        exchangeTradedFundRepository.save(exchangeTradedFund);
    }
    @Override
    @Transactional
    public void sellExchangeTradedFund(ExchangeTradedFund exchangeTradedFund) {
        Collection<ExchangeTradedFund> recentTransactions = exchangeTradedFundRepository.getLatestExchangeTradedFundTransactionBySymbol(exchangeTradedFund.getSymbol());;
        if (recentTransactions.size() > 0) {
            ExchangeTradedFund recentTransaction = recentTransactions.iterator().next();
            if (exchangeTradedFund.getQuantityAffected() <= recentTransaction.getTotalQuantity()) {
                exchangeTradedFund.setTotalQuantity(recentTransaction.getTotalQuantity() - exchangeTradedFund.getQuantityAffected());
                exchangeTradedFund.setTotalValue(exchangeTradedFund.getTotalQuantity() * exchangeTradedFund.getMarketValue());
            }
            exchangeTradedFundRepository.save(exchangeTradedFund);
        }
    }

    /**
     * CASH METHODS
     */
    @Override
    public Collection<Cash> getAllCash() { return cashRepository.findAllSorted(); }
    @Override
    public Collection<Cash> getCashByTransactionType(int type) { return cashRepository.findByTransactionType(type); }
    @Override
    public Collection<Cash> getCashByAccountType(int type) { return cashRepository.findByAccountType(type); }
    @Override
    public Collection<Cash> getCashByAccountNumber(int account) { return cashRepository.findByAccountNumber(account); }
    @Override
    public Collection<Cash> getCashByFinancialInstitution(String institution) { return cashRepository.findByFinancialInstitution(institution); }
    @Override
    @Transactional
    public void depositCash(Cash cash) {
        Collection<Cash> recentTransactions = cashRepository.getLatestCashAccountTransactionByAccountNumber(cash.getAccountNumber());
        if (recentTransactions.size() > 0) {
            Cash recentTransaction = recentTransactions.iterator().next();
            cash.setBalance(recentTransaction.getBalance() + cash.getTransactionAmount());
        }
        else cash.setBalance(cash.getTransactionAmount());
        cashRepository.save(cash);
    }
    @Override
    @Transactional
    public void withdrawCash(Cash cash) {
        Collection<Cash> recentTransactions = cashRepository.getLatestCashAccountTransactionByAccountNumber(cash.getAccountNumber());
        if (recentTransactions.size() > 0) {
            Cash recentTransaction = recentTransactions.iterator().next();
            if (cash.getTransactionAmount() <= recentTransaction.getBalance()) {
                cash.setBalance(recentTransaction.getBalance() - cash.getTransactionAmount());
                cashRepository.save(cash);
            }
        }
    }

    /**
     * BOND METHODS
     */
    @Override
    public Collection<Bond> getAllBonds() {
        return bondRepository.findAllSorted();
    }
    @Override
    public Collection<Bond> getBondsByIssuer(String issuer) {
        return bondRepository.findByIssuer(issuer);
    }
    @Override
    public Collection<Bond> getBondsByName(String name) {
        return bondRepository.findByName(name);
    }
    @Override
    public Collection<Bond> getBondsByBondType(String bondType) {
        return bondRepository.findByBondType(bondType);
    }

    /**
     * PORTFOLIO METHODS
     */
    @Override
    public double dummyCurrentMarketValue(String symbol) {
        return 52.3;
    }
    @Override
    public double getInvestmentValue() {
        Collection<Stock> stocksTotal = stockRepository.getAllLatestStocks();
        double investmentValue = 0;
        for(Stock stock: stocksTotal) {
            investmentValue += (stock.getTotalQuantity() * dummyCurrentMarketValue(stock.getSymbol()));
        }

        Collection<ExchangeTradedFund> exchangeTradedFundTotal = exchangeTradedFundRepository.getAllLatestExchangeTradedFunds();
        for(ExchangeTradedFund exchangeTradedFund: exchangeTradedFundTotal) {
            investmentValue += (exchangeTradedFund.getTotalQuantity() * dummyCurrentMarketValue(exchangeTradedFund.getSymbol()));
        }
        return investmentValue;
    }
    @Override
    public double getCashValue() {
        Collection<Cash> cashTotal = cashRepository.getAllLatestCashAccounts();
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
    @Override
    public double dummyCurrentMarketMover(String symbol) {
        double moveAmount = Math.floor((Math.random() * 3.8)) / 100; // Return random value between 0 and 3.8%, truncating to 2 decimal places
        if (Math.round(Math.random()) == 1) moveAmount *= -1; // Random chance its either a gain or loss
        return moveAmount;
    }
    @Override
    public Collection<HashMap> getMarketMovers() {
        HashMap marketGainers = new HashMap<>();
        HashMap marketLosers = new HashMap<>();
        Collection<HashMap> marketMovers = new ArrayList<HashMap>(Arrays.asList(marketGainers, marketLosers));

        // Stock Analysis
        Collection<Stock> latestStocks = stockRepository.getAllLatestStocks();


        return marketMovers;
    }

    //Assume a bond can only be bought once
    @Override
    @Transactional
    public void buyBond(Bond bond) {
        bondRepository.save(bond);
    }

    //Assume a bond has to be sold as a whole
    @Override
    @Transactional
    public void sellBond(String bondName) {
        Collection<Bond> recentTransactions = bondRepository.getLatestBondTransaction(bondName);
        if (recentTransactions.size() > 0) {
            Bond recentTransaction = recentTransactions.iterator().next();
            if(recentTransaction.getTotalValue()>0){
                Bond newTransaction = recentTransaction;
                newTransaction.setFaceValue(0);
                newTransaction.setTotalValue(0);
                newTransaction.setDateTime(LocalDateTime.now());
                newTransaction.setTransactionType(1);
                bondRepository.save(newTransaction);
            }

        }
    }
}
