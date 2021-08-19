package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Cash;
import com.citi.training.portfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public interface CashRepository extends JpaRepository<Cash, Integer> {

    /**
     * Locates all cash accounts sorted by date ascending.
     * @return Collection of all cash accounts sorted by date time ascending.
     */
    @Query(
            value = "SELECT * from cash order by date_time asc",
            nativeQuery = true)
    Collection<Cash> findAllSorted();

    /**
     * Locates a cash account based on account type.
     * @param account the account type to be used in the lookup.
     * @return Collection of cash accounts that match the account type provided.
     */
    Collection<Cash> findByAccountType(int account);

    /**
     * Locates a cash account based on transaction type.
     * @param type the transaction type to be used in the lookup.
     * @return Collection of cash accounts that match the transaction type provided.
     */
    Collection<Cash> findByTransactionType(int type);

    /**
     * Locates a cash account based on institution.
     * @param institution the institution name to be used in the lookup.
     * @return Collection of cash accounts that match the institution provided.
     */
    Collection<Cash> findByFinancialInstitution(String institution);

    /**
     * Locates a cash account based on account number.
     * @param number the account number to be used in the lookup.
     * @return Collection of cash accounts that match the account number provided.
     */
    Collection<Cash> findByAccountNumber(int number);

    /**
     * Retrieves the latest transaction of each cash account.
     * @return Collection of the latest transaction for each cash account.
     */
    @Query(
            value = "SELECT * from cash t1 where date_time = (select max(date_time) from cash where t1.account_number = cash.account_number) order by date_time desc",
            nativeQuery = true)
    Collection<Cash> getLatestCashAccounts();

    /**
     * Retrieves all income transactions within 30 days
     * @return Collection of income transactions within 30 days.
     */
    @Query(
            //value = "SELECT * from cash t1 where (t1.transaction_type = 0) (date_time >= (LocalDateTime.of(2021, 5, 30, 0, 0)))",
            value = "SELECT * from cash t1 where (t1.transaction_type = 0) AND (date_time >= ('2021-05-30'))",
            nativeQuery = true)
    Collection<Cash> getLatestIncomeCashFlows();
    /**
     * Retrieves all spending transactions within 30 days
     * @return Collection of spending transactions within 30 days.
     */
    @Query(
            value = "SELECT * from cash t1 where (t1.transaction_type = 1) AND (date_time >= ('2021-05-30'))",
            nativeQuery = true)
    Collection<Cash> getLatestExpenseCashFlows();

    /**
     * Retrieves all cash transactions on a given day
     * @return Collection of the latest transaction for each cash account.
     */
    @Query(
            value = "SELECT * from cash t1 where (DATE(date_time) = :day)",
            nativeQuery = true)
    Collection<Cash> getAllCashByDay(@Param("day") LocalDate day);
}
