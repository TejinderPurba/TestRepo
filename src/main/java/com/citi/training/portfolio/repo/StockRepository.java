package com.citi.training.portfolio.repo;


import com.citi.training.portfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Collection<Stock> findBySymbol(String symbol);

    Collection<Stock> findByName(String name);

    Collection<Stock> findByTransactionType(int type);

    @Query(
            value = "SELECT * from stocks t1 where date_time = (select max(date_time) from stocks where t1.symbol = stocks.symbol) order by date_time desc",
            nativeQuery = true)
    Collection<Stock> getLatestStocks();
}