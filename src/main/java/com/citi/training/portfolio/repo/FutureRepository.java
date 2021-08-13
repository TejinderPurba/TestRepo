package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FutureRepository extends JpaRepository<Future, Integer> {

    /**
     * Locates a future based on symbol.
     * @param symbol the future symbol to be used in the lookup.
     * @return Collection of futures that match the symbol provided.
     */
    Collection<Future> findBySymbol(String symbol);
}
