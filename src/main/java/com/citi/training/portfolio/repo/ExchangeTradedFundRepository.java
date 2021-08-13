package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.ExchangeTradedFund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ExchangeTradedFundRepository extends JpaRepository<ExchangeTradedFund, Integer> {
    Collection<ExchangeTradedFund> findBySymbol(String title);

    @Query(
            value = "SELECT * from exchange_traded_funds t1 where date_time = (select max(date_time) from exchange_traded_funds where t1.symbol = exchange_traded_funds.symbol) order by date_time desc",
            nativeQuery = true)
    Collection<ExchangeTradedFund> getLatestExchangeTradedFunds();
}
