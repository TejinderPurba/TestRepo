package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.ExchangeTradedFund;
import com.citi.training.portfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ExchangeTradedFundRepository extends JpaRepository<ExchangeTradedFund, Integer> {

    /**
     * Locates all ETFs sorted by date ascending.
     * @return Collection of all ETFs sorted by date time ascending.
     */
    @Query(
            value = "SELECT * from exchange_traded_funds order by date_time asc",
            nativeQuery = true)
    Collection<ExchangeTradedFund> findAllSorted();

    /**
     * Locates an ETF based on symbol.
     * @param symbol the ETF symbol to be used in the lookup.
     * @return Collection of ETFs that match the symbol provided.
     */
    Collection<ExchangeTradedFund> findBySymbol(String symbol);

    /**
     * Locates an ETF based on name.
     * @param name the ETF name to be used in the lookup.
     * @return Collection of ETFs that match the name provided.
     */
    Collection<ExchangeTradedFund> findByName(String name);

    /**
     * Locates an ETF based on type.
     * @param type the ETF type to be used in the lookup.
     * @return Collection of ETFs that match the type provided.
     */
    Collection<ExchangeTradedFund> findByTransactionType(int type);

    /**
     * Retrieves the latest transaction of each ETF.
     * @return Collection of the latest transaction for each ETF.
     */
    @Query(
            value = "SELECT * from exchange_traded_funds t1 where date_time = (select max(date_time) from exchange_traded_funds where t1.symbol = exchange_traded_funds.symbol) order by date_time desc",
            nativeQuery = true)
    Collection<ExchangeTradedFund> getLatestExchangeTradedFunds();
}
