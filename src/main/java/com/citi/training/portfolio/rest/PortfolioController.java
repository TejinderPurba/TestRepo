package com.citi.training.portfolio.rest;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.service.PortfolioService;
import com.citi.training.portfolio.service.PortfolioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedMap;

@RestController
@CrossOrigin
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    /**
     * BOND METHODS
     */
    @RequestMapping(value = "/bonds", method = {RequestMethod.GET})
    public Collection<Bond> getAllBonds() {
        return portfolioService.getAllBonds();
    }

    @RequestMapping(value = "/latestbonds", method = {RequestMethod.GET})
    public Collection<Bond> getAllLatestBonds() {
        return portfolioService.getAllLatestBonds();
    }

    @RequestMapping(value = "/bonds/issuer/{issuer}", method = {RequestMethod.GET})
    public Collection<Bond> getBondsByIssuer(@PathVariable String issuer) {
        return portfolioService.getBondsByIssuer(issuer);
    }

    @RequestMapping(value = "/bonds/transactiontype/{transactionType}", method = {RequestMethod.GET})
    public Collection<Bond> getBondsByTransactionType(@PathVariable int transactionType) {
        return portfolioService.getBondsByTransactionType(transactionType);
    }

    @RequestMapping(value = "/bonds/name/{name}", method = {RequestMethod.GET})
    public Collection<Bond> getBondsByName(@PathVariable String name) {
        return portfolioService.getBondsByName(name);
    }

    @RequestMapping(value = "/bonds/bondtype/{type}", method = {RequestMethod.GET})
    public Collection<Bond> getBondsByBondType(@PathVariable String type) {
        return portfolioService.getBondsByBondType(type);
    }
    @RequestMapping(value = "/bonds/buy", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity buyBond(@RequestBody Bond bond) {
        portfolioService.buyBond(bond);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/bonds/sell", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity sellBond(@RequestBody Bond bond) {
        portfolioService.sellBond(bond);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    /**
     * STOCK METHODS
     */
    @RequestMapping(value = "/stocks", method = {RequestMethod.GET})
    public Collection<Stock> getAllStocks() {
        return portfolioService.getAllStocks();
    }

    @RequestMapping(value = "/lateststocks", method = {RequestMethod.GET})
    public Collection<Stock> getAllLatestStocks() {
        return portfolioService.getAllLatestStocks();
    }

    @RequestMapping(value = "/stocks/symbol/{symbol}", method = {RequestMethod.GET})
    public Collection<Stock> getStocksBySymbol(@PathVariable String symbol) {
        return portfolioService.getStocksBySymbol(symbol);
    }

    @RequestMapping(value = "/stocks/name/{name}", method = {RequestMethod.GET})
    public Collection<Stock> getStocksByName(@PathVariable String name) {
        return portfolioService.getStocksByName(name);
    }

    @RequestMapping(value = "/stocks/type/{type}", method = {RequestMethod.GET})
    public Collection<Stock> getStocksByType(@PathVariable int type) {
        return portfolioService.getStocksByType(type);
    }

    @RequestMapping(value = "/stocks/buy", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity buyStock(@RequestBody Stock stock) {
        portfolioService.buyStock(stock);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/stocks/sell", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity sellStock(@RequestBody Stock stock) {
        portfolioService.sellStock(stock);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    /**
     * EXCHANGE TRADED FUND METHODS
     */
    @RequestMapping(value = "/etfs", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds() { return portfolioService.getAllExchangeTradedFunds(); }

    @RequestMapping(value = "/latestetfs", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getAllLatestExchangeTradedFunds() { return portfolioService.getAllLatestExchangeTradedFunds(); }

    @RequestMapping(value = "/etfs/symbol/{symbol}", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getExchangeTradedFundsBySymbol(@PathVariable String symbol) {
        return portfolioService.getExchangeTradedFundsBySymbol(symbol);
    }

    @RequestMapping(value = "/etfs/name/{name}", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getExchangeTradedFundsByName(@PathVariable String name) {
        return portfolioService.getExchangeTradedFundsByName(name);
    }

    @RequestMapping(value = "/etfs/type/{type}", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getExchangeTradedFundsByType(@PathVariable int type) {
        return portfolioService.getExchangeTradedFundsByType(type);
    }

    @RequestMapping(value = "/etfs/buy", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity buyExchangeTradedFund(@RequestBody ExchangeTradedFund exchangeTradedFund) {
        portfolioService.buyExchangeTradedFund(exchangeTradedFund);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/etfs/sell", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity sellExchangeTradedFund(@RequestBody ExchangeTradedFund exchangeTradedFund) {
        portfolioService.sellExchangeTradedFund(exchangeTradedFund);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    /**
     * CASH METHODS
     */
    @RequestMapping(value = "/cash", method = {RequestMethod.GET})
    public Collection<Cash> getAllCash() {
        return portfolioService.getAllCash();
    }

    @RequestMapping(value = "/latestcash", method = {RequestMethod.GET})
    public Collection<Cash> getAllLatestCash() {
        return portfolioService.getAllLatestCash();
    }

    @RequestMapping(value = "/cash/account/{accountNum}", method = {RequestMethod.GET})
    public Collection<Cash> getCashByAccountNumber(@PathVariable int accountNum) {
        return portfolioService.getCashByAccountNumber(accountNum);
    }

    @RequestMapping(value = "/cash/institution/{institution}", method = {RequestMethod.GET})
    public Collection<Cash> getCashByFinancialInstitution (@PathVariable String institution) {
        return portfolioService.getCashByFinancialInstitution(institution);
    }

    @RequestMapping(value = "/cash/accounttype/{accountType}", method = {RequestMethod.GET})
    public Collection<Cash> getCashByAccountType(@PathVariable int accountType) {
        return portfolioService.getCashByAccountType(accountType);
    }

    @RequestMapping(value = "/cash/transactiontype/{transactionType}", method = {RequestMethod.GET})
    public Collection<Cash> getCashByTransactionType(@PathVariable int transactionType) {
        return portfolioService.getCashByTransactionType(transactionType);
    }

    @RequestMapping(value = "/cash/deposit", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity depositCash(@RequestBody Cash cash) {
        portfolioService.depositCash(cash);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/cash/withdraw", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity withdrawCash(@RequestBody Cash cash) {
        portfolioService.withdrawCash(cash);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    /**
     * PORTFOLIO METHODS
     */
    @RequestMapping(value = "/investmentvalue", method = {RequestMethod.GET})
    public double getInvestmentValue() {
        return portfolioService.getInvestmentValue();
    }

    @RequestMapping(value = "/cashvalue", method = {RequestMethod.GET})
    public double getCashValue() {
        return portfolioService.getCashValue();
    }

    @RequestMapping(value = "/networth", method = {RequestMethod.GET})
    public double[] getNetWorth() {
        return portfolioService.getNetWorth();
    }

    @RequestMapping(value = "/marketmovers/{period}", method = {RequestMethod.GET})
    public SortedMap getMarketMovers(@PathVariable int period) { return portfolioService.getMarketMovers(period); }

    @RequestMapping(value = "/cashincomeflow/{date}", method = {RequestMethod.GET})
    public double[] getIncomeCashFlow(@PathVariable String date){ return portfolioService.getIncomeCashFlow(date); }

    @RequestMapping(value = "/cashexpenseflow/{date}", method = {RequestMethod.GET})
    public double[] getExpenseCashFlow(@PathVariable String date){ return portfolioService.getExpenseCashFlow(date); }

    @RequestMapping(value = "/cashflow/{date}", method = {RequestMethod.GET})
    public double getCashFlow(@PathVariable String date){ return portfolioService.getCashFlow(date); }

    @RequestMapping(value = "/cashhistory", method = {RequestMethod.GET})
    public SortedMap<LocalDate, Double> getCashHistory(){ return portfolioService.getCashHistory(); }

    @RequestMapping(value = "/stockhistory", method = {RequestMethod.GET})
    public SortedMap<LocalDate, Double> getStockHistory(){ return portfolioService.getStockHistory(); }

    @RequestMapping(value = "/etfhistory", method = {RequestMethod.GET})
    public SortedMap<LocalDate, Double> getExchangeTradedFundHistory(){ return portfolioService.getExchangeTradedFundHistory(); }

    @RequestMapping(value = "/bondhistory", method = {RequestMethod.GET})
    public SortedMap<LocalDate, Double> getBondHistory(){ return portfolioService.getBondHistory(); }

    @RequestMapping(value = "/networthhistory", method = {RequestMethod.GET})
    public LinkedList<PortfolioServiceImpl.GraphData> getNetworthHistory(){ return portfolioService.getNetWorthHistory(); }
}
