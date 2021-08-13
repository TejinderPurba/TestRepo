package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CashRepository extends JpaRepository<Cash, Integer> {
    Collection<Cash> findByAccountType(int accountType);
}
