package com.citi.training.portfolio.repo;


import com.citi.training.portfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

    /**
     * Locates a stock based on symbol.
     * @param symbol the stock symbol to be used in the lookup.
     * @return Collection of stocks that match the symbol provided.
     */
    Collection<Stock> findBySymbol(String symbol);

    /**
     * Locates a stock based on name.
     * @param name the stock name to be used in the lookup.
     * @return Collection of stocks that match the name provided.
     */
    Collection<Stock> findByName(String name);

    /**
     * Locates a stock based on type.
     * @param type the stock type to be used in the lookup.
     * @return Collection of stocks that match the type provided.
     */
    Collection<Stock> findByTransactionType(int type);

    /**
     * Retrieves the latest transaction of each stock.
     * @return Collection of the latest transaction for each stock.
     */
    @Query(
            value = "SELECT * from stocks t1 where date_time = (select max(date_time) from stocks where t1.symbol = stocks.symbol) order by date_time desc",
            nativeQuery = true)
    Collection<Stock> getAllLatestStocks();

    /**
     * Retrieves the latest transaction of a specific stock.
     * @param symbol the stock symbol to be fetched.
     * @return The latest transaction for the specified stock.
     */
    @Query(
            value = "SELECT * from stocks t1 where date_time = (select max(date_time) from stocks where stocks.symbol = :symbol) order by date_time desc",
            nativeQuery = true)
    Stock getLatestStockTransaction(@Param("symbol") String symbol);
}