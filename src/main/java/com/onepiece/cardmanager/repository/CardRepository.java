package com.onepiece.cardmanager.repository;

import com.onepiece.cardmanager.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CardRepository extends JpaRepository<Card, Long> {
    // Find cards by name (case-insensitive, partial match)
    List<Card> findByNameContainingIgnoreCase(String name);
    
    // Find cards by card type
    List<Card> findByCardType(String cardType);
    
    // Find cards by affiliations (partial match)
    List<Card> findByAffiliationsContainingIgnoreCase(String affiliation);
    
    // Find cards by power range
    List<Card> findByPowerBetween(Integer minPower, Integer maxPower);
    
    // Find cards by card number
    Optional<Card> findByCardNumber(String cardNumber);
    
    // Custom query to find cards by multiple criteria
    @Query("SELECT c FROM Card c WHERE " +
           "(:cardType IS NULL OR c.cardType = :cardType) AND " +
           "(:minPower IS NULL OR c.power >= :minPower) AND " +
           "(:maxPower IS NULL OR c.power <= :maxPower) AND " +
           "(:affiliation IS NULL OR LOWER(c.affiliations) LIKE LOWER(CONCAT('%', :affiliation, '%')))")
    List<Card> findByMultipleCriteria(
        @Param("cardType") String cardType,
        @Param("minPower") Integer minPower,
        @Param("maxPower") Integer maxPower,
        @Param("affiliation") String affiliation
    );
} 