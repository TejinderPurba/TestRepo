package com.citi.training.portfolio.repo;


import com.citi.training.portfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Collection<Stock> findBySymbol(String title);
}
