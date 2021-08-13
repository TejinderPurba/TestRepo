package com.citi.training.portfolio.rest;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/stocks", method = {RequestMethod.GET})
    public Collection<Stock> getAllStocks() {
        return portfolioService.getAllStocks();
    }

    @RequestMapping(value = "/etf", method = {RequestMethod.GET})
    public Collection<ExchangeTradedFund> getAllExchangeTradedFunds() {
        return portfolioService.getAllExchangeTradedFunds();
    }

    @RequestMapping(value = "/cash", method = {RequestMethod.GET})
    public Collection<Cash> getAllCash() {
        return portfolioService.getAllCash();
    }

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
