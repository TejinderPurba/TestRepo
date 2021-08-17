package com.citi.training.portfolio.rest;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    /**
     * STOCK METHODS
     */
    @RequestMapping(value = "/stocks", method = {RequestMethod.GET})
    public Collection<Stock> getAllStocks() {
        return portfolioService.getAllStocks();
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
    @RequestMapping(value = "/etf", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds() { return portfolioService.getAllExchangeTradedFunds(); }

    /**
     * CASH METHODS
     */
    @RequestMapping(value = "/cash", method = {RequestMethod.GET})
    public Collection<Cash> getAllCash() {
        return portfolioService.getAllCash();
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

}
