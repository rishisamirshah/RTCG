package com.onepiece.cardmanager.repository;

import com.onepiece.cardmanager.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>, JpaSpecificationExecutor<Card> {
    // Basic search methods
    List<Card> findByNameContainingIgnoreCase(String name);
    List<Card> findByCardType(String cardType);
    List<Card> findByAffiliationsContainingIgnoreCase(String affiliation);
    List<Card> findByPowerBetween(Integer minPower, Integer maxPower);
    Optional<Card> findByCardNumber(String cardNumber);
    
    // Set related methods
    @Query("SELECT c FROM Card c WHERE c.set = :set")
    List<Card> findBySet(@Param("set") String set);
    
    @Query("SELECT c FROM Card c WHERE c.set LIKE CONCAT(:setPrefix, '%')")
    List<Card> findBySetStartingWith(@Param("setPrefix") String setPrefix);
    
    // New search methods
    List<Card> findByColor(String color);
    List<Card> findByColorContaining(String color); // For multi-color cards
    List<Card> findByCostBetween(Integer minCost, Integer maxCost);
    List<Card> findByLife(Integer life);
    List<Card> findByEffectContainingIgnoreCase(String effectText);
    List<Card> findByAttribute(String attribute);
    List<Card> findByTiming(String timing);
    
    // Enhanced multiple criteria search
    @Query("SELECT c FROM Card c WHERE " +
           "(:cardType IS NULL OR c.cardType = :cardType) AND " +
           "(:color IS NULL OR c.color LIKE %:color%) AND " +
           "(:minPower IS NULL OR c.power >= :minPower) AND " +
           "(:maxPower IS NULL OR c.power <= :maxPower) AND " +
           "(:minCost IS NULL OR c.cost >= :minCost) AND " +
           "(:maxCost IS NULL OR c.cost <= :maxCost) AND " +
           "(:life IS NULL OR c.life = :life) AND " +
           "(:attribute IS NULL OR c.attribute = :attribute) AND " +
           "(:timing IS NULL OR c.timing = :timing) AND " +
           "(:effectText IS NULL OR LOWER(c.effect) LIKE LOWER(CONCAT('%', :effectText, '%'))) AND " +
           "(:affiliation IS NULL OR LOWER(c.affiliations) LIKE LOWER(CONCAT('%', :affiliation, '%'))) AND " +
           "(:set IS NULL OR c.set = :set)")
    List<Card> findByMultipleCriteria(
        @Param("cardType") String cardType,
        @Param("color") String color,
        @Param("minPower") Integer minPower,
        @Param("maxPower") Integer maxPower,
        @Param("minCost") Integer minCost,
        @Param("maxCost") Integer maxCost,
        @Param("life") Integer life,
        @Param("attribute") String attribute,
        @Param("timing") String timing,
        @Param("effectText") String effectText,
        @Param("affiliation") String affiliation,
        @Param("set") String set
    );

    /**
     * Count cards by set and card number starting with a specific prefix
     * @param set The set name (e.g., "OP01")
     * @param cardNumberPrefix The card number prefix (e.g., "OP01")
     * @return The count of matching cards
     */
    long countBySetAndCardNumberStartingWith(String set, String cardNumberPrefix);

    // Define the signature for the filtering method
    // The actual implementation will use Specifications or Criteria API
    // List<Card> findWithFilters(
    //         String searchTerm,
    //         Set<String> colors,
    //         Set<Integer> costs,
    //         Set<String> types,
    //         Set<String> sets
    // );

    // Method needed by DeckController to find cards by their string ID
    Optional<Card> findByCardNumberIgnoreCase(String cardNumber);

    // Example of custom query with parameters (existing)
    @Query("SELECT c FROM Card c WHERE " +
           "(:searchTerm IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%\', :searchTerm, '%'))) AND " +
           "(:colors IS NULL OR c.color IN :colors) AND " +
           "(:costs IS NULL OR c.cost IN :costs) AND " +
           "(:types IS NULL OR c.cardType IN :types) AND " +
           "(:sets IS NULL OR c.set IN :sets)")
    List<Card> findByCriteria(
            @Param("searchTerm") String searchTerm,
            @Param("colors") List<String> colors,
            @Param("costs") List<Integer> costs,
            @Param("types") List<String> types,
            @Param("sets") List<String> sets
    );
} 