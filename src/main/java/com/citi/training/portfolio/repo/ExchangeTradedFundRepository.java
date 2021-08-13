package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.ExchangeTradedFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ExchangeTradedFundRepository extends JpaRepository<ExchangeTradedFund, Integer> {
    Collection<ExchangeTradedFund> findBySymbol(String title);
}
