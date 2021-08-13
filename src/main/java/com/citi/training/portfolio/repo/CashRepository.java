package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Cash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CashRepository extends JpaRepository<Cash, Integer> {

    /**
     * Locates a cash account based on account type.
     * @param accountType the account type to be used in the lookup.
     * @return Collection of cash accounts that match the account type provided.
     */
    Collection<Cash> findByAccountType(int accountType);

    /**
     * Retrieves the latest transaction of each cash account.
     * @return Collection of the latest transaction for each cash account.
     */
    @Query(
            value = "SELECT * from cash t1 where date_time = (select max(date_time) from cash where t1.account_number = cash.account_number) order by date_time desc",
            nativeQuery = true)
    Collection<Cash> getLatestCashAccounts();
}
