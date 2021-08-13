package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Future;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface FutureRepository extends JpaRepository<Future, Integer> {
    Collection<Future> findBySymbol(String title);
}
