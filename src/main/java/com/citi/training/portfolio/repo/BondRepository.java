package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BondRepository extends JpaRepository<Bond, Integer> {

    /**
     * Locates a bond based on symbol.
     * @param symbol the bond symbol to be used in the lookup.
     * @return Collection of bonds that match the symbol provided.
     */
    Collection<Bond> findBySymbol(String symbol);
}
