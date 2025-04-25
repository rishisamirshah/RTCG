package com.onepiece.cardmanager.specification;

import com.onepiece.cardmanager.model.Card;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CardSpecification {

    public static Specification<Card> createSpecification(
            String searchTerm,
            Set<String> colors,
            Set<Integer> costs,
            Set<String> types,
            Set<String> sets
            // Add more parameters here
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            // Search Term (Name or Effect)
            if (StringUtils.hasText(searchTerm)) {
                String likePattern = "%" + searchTerm.toLowerCase() + "%";
                Predicate namePredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), likePattern);
                Predicate effectPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("effect")), likePattern);
                // Add other searchable text fields if needed (e.g., affiliations)
                // Predicate affiliationsPredicate = criteriaBuilder.like(criteriaBuilder.lower(root.get("affiliations")), likePattern);
                predicates.add(criteriaBuilder.or(namePredicate, effectPredicate /*, affiliationsPredicate */));
            }

            // Colors Filter (Handles single or multi-color fields like "Red/Green")
            if (!CollectionUtils.isEmpty(colors)) {
                List<Predicate> colorPredicates = new ArrayList<>();
                for (String color : colors) {
                    // Check if the color exists anywhere in the potentially multi-value color field
                    colorPredicates.add(criteriaBuilder.like(root.get("color"), "%" + color + "%"));
                }
                 if (!colorPredicates.isEmpty()) {
                    predicates.add(criteriaBuilder.or(colorPredicates.toArray(new Predicate[0])));
                }
            }

            // Costs Filter
            if (!CollectionUtils.isEmpty(costs)) {
                predicates.add(root.get("cost").in(costs));
            }

            // Types Filter
            if (!CollectionUtils.isEmpty(types)) {
                predicates.add(root.get("cardType").in(types));
            }

            // Sets Filter
            if (!CollectionUtils.isEmpty(sets)) {
                predicates.add(root.get("set").in(sets));
            }

            // Combine all predicates with AND
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
} 