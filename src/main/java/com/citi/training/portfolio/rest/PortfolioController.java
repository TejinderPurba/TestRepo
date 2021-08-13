package com.citi.training.portfolio.rest;

import com.citi.training.portfolio.entities.*;
import com.citi.training.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;


    @RequestMapping(value = "/stocks", method = {RequestMethod.GET})
    public Collection<Stock> getStocks() {
        return portfolioService.getStocks();
    }

    @RequestMapping(value = "/cash", method = {RequestMethod.GET})
    public Collection<Cash> getCash() {
        return portfolioService.getCash();
    }

}
