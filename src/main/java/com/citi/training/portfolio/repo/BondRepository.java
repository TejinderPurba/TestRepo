package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Bond;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BondRepository extends JpaRepository<Bond, Integer> {
    Collection<Bond> findBySymbol(String title);
}
