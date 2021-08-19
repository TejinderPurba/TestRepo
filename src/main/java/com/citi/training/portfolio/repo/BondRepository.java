package com.citi.training.portfolio.repo;

import com.citi.training.portfolio.entities.Bond;
import com.citi.training.portfolio.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface BondRepository extends JpaRepository<Bond, Integer> {

    /**
     * Locates a bond based on issuer.
     * @param issuer the bond issuer to be used in the lookup.
     * @return Collection of bonds that match the issuer provided.
     */
    Collection<Bond> findByIssuer(String issuer);

    /**
     * Locates all bonds sorted by maturity ascending.
     * @return Collection of all bonds sorted by maturity ascending.
     */
    @Query(
            value = "SELECT * from bonds order by date_time asc",
            nativeQuery = true)
    Collection<Bond> findAllSorted();

    /**
     * Locates a bond based on name.
     * @param name the bond name to be used in the lookup.
     * @return Collection of bonds that match the name provided.
     */
    Collection<Bond> findByName(String name);

    /**
     * Locates a bond based on bond type.
     * @param bondType the bond type to be used in the lookup.
     * @return Collection of bonds that match the name provided.
     */
    Collection<Bond> findByBondType(String bondType);

    /**
     * Locates a bond based on transaction type.
     * @param type the bond transaction type to be used in the lookup.
     * @return Collection of bonds that match the transaction type provided.
     */
    Collection<Bond> findByTransactionType(int type);

    /**
     * Retrieves the latest transaction of each bond.
     * @return Collection of the latest transaction for each bond.
     */
    @Query(
            value = "SELECT * from bonds t1 where date_time = (select max(date_time) from bonds where t1.name = bonds.name) order by date_time desc",
            nativeQuery = true)
    Collection<Bond> getAllLatestBonds();

    /**
     * Retrieves the latest transaction of a specific bond.
     * @param name the bond name to be fetched.
     * @return The latest transaction for the specified bond.
     */
    @Query(
            value = "SELECT * from bonds t1 where date_time = (select max(date_time) from bonds where bonds.name = :name) order by date_time desc",
            nativeQuery = true)
    Collection<Bond> getLatestBondTransaction(@Param("name") String name);
}
