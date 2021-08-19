package com.citi.training.portfolio.service;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    public void buyStock(Stock stock) { stockRepository.save(stock); }
    @Override
    @Transactional
    public void sellStock(Stock stock) {
        Stock recentTransaction = stockRepository.getLatestStockTransaction(stock.getSymbol());
        if (stock.getQuantityAffected() <= recentTransaction.getTotalQuantity()) {
            stock.setTotalQuantity(recentTransaction.getTotalQuantity() - stock.getQuantityAffected());
            stock.setTotalValue(stock.getTotalQuantity() * stock.getMarketValue());
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

        Collection<ExchangeTradedFund> exchangeTradedFundTotal = exchangeTradedFundRepository.getLatestExchangeTradedFunds();
        for(ExchangeTradedFund exchangeTradedFund: exchangeTradedFundTotal) {
            investmentValue += (exchangeTradedFund.getTotalQuantity() * dummyCurrentMarketValue(exchangeTradedFund.getSymbol()));
        }
        return investmentValue;
    }
    @Override
    public double getCashValue() {
        Collection<Cash> cashTotal = cashRepository.getLatestCashAccounts();
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
}
