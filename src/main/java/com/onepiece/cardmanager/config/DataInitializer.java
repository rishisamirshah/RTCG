package com.onepiece.cardmanager.config;

import com.onepiece.cardmanager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// Import statements for ST initializers will be needed here eventually
import com.onepiece.cardmanager.config.st.ST01Initializer;
import com.onepiece.cardmanager.config.st.ST02Initializer;
import com.onepiece.cardmanager.config.st.ST03Initializer;
import com.onepiece.cardmanager.config.st.ST04Initializer;
import com.onepiece.cardmanager.config.st.ST05Initializer;
import com.onepiece.cardmanager.config.st.ST06Initializer;
import com.onepiece.cardmanager.config.st.ST07Initializer;
import com.onepiece.cardmanager.config.st.ST08Initializer;
import com.onepiece.cardmanager.config.st.ST09Initializer;
import com.onepiece.cardmanager.config.st.ST10Initializer;
import com.onepiece.cardmanager.config.st.ST11Initializer;
import com.onepiece.cardmanager.config.st.ST12Initializer;
import com.onepiece.cardmanager.config.st.ST13Initializer;
import com.onepiece.cardmanager.config.st.ST14Initializer;
import com.onepiece.cardmanager.config.st.ST15Initializer;
import com.onepiece.cardmanager.config.st.ST16Initializer;
import com.onepiece.cardmanager.config.st.ST17Initializer;
import com.onepiece.cardmanager.config.st.ST18Initializer;
import com.onepiece.cardmanager.config.st.ST19Initializer;
import com.onepiece.cardmanager.config.st.ST20Initializer;
import com.onepiece.cardmanager.config.st.ST21Initializer;


@Component
@Order(0)
public class DataInitializer implements CommandLineRunner {

    private final CardRepository cardRepository;
    // Add fields for ST initializers
    private final ST01Initializer st01Initializer;
    private final ST02Initializer st02Initializer;
    private final ST03Initializer st03Initializer;
    private final ST04Initializer st04Initializer;
    private final ST05Initializer st05Initializer;
    private final ST06Initializer st06Initializer;
    private final ST07Initializer st07Initializer;
    private final ST08Initializer st08Initializer;
    private final ST09Initializer st09Initializer;
    private final ST10Initializer st10Initializer;
    private final ST11Initializer st11Initializer;
    private final ST12Initializer st12Initializer;
    private final ST13Initializer st13Initializer;
    private final ST14Initializer st14Initializer;
    private final ST15Initializer st15Initializer;
    private final ST16Initializer st16Initializer;
    private final ST17Initializer st17Initializer;
    private final ST18Initializer st18Initializer;
    private final ST19Initializer st19Initializer;
    private final ST20Initializer st20Initializer;
    private final ST21Initializer st21Initializer;


    @Autowired
    public DataInitializer(CardRepository cardRepository,
                           ST01Initializer st01Initializer,
                           ST02Initializer st02Initializer,
                           ST03Initializer st03Initializer,
                           ST04Initializer st04Initializer,
                           ST05Initializer st05Initializer,
                           ST06Initializer st06Initializer,
                           ST07Initializer st07Initializer,
                           ST08Initializer st08Initializer,
                           ST09Initializer st09Initializer,
                           ST10Initializer st10Initializer,
                           ST11Initializer st11Initializer,
                           ST12Initializer st12Initializer,
                           ST13Initializer st13Initializer,
                           ST14Initializer st14Initializer,
                           ST15Initializer st15Initializer,
                           ST16Initializer st16Initializer,
                           ST17Initializer st17Initializer,
                           ST18Initializer st18Initializer,
                           ST19Initializer st19Initializer,
                           ST20Initializer st20Initializer,
                           ST21Initializer st21Initializer) {
        this.cardRepository = cardRepository;
        this.st01Initializer = st01Initializer;
        this.st02Initializer = st02Initializer;
        this.st03Initializer = st03Initializer;
        this.st04Initializer = st04Initializer;
        this.st05Initializer = st05Initializer;
        this.st06Initializer = st06Initializer;
        this.st07Initializer = st07Initializer;
        this.st08Initializer = st08Initializer;
        this.st09Initializer = st09Initializer;
        this.st10Initializer = st10Initializer;
        this.st11Initializer = st11Initializer;
        this.st12Initializer = st12Initializer;
        this.st13Initializer = st13Initializer;
        this.st14Initializer = st14Initializer;
        this.st15Initializer = st15Initializer;
        this.st16Initializer = st16Initializer;
        this.st17Initializer = st17Initializer;
        this.st18Initializer = st18Initializer;
        this.st19Initializer = st19Initializer;
        this.st20Initializer = st20Initializer;
        this.st21Initializer = st21Initializer;
    }

    @Override
    public void run(String... args) throws Exception {
        // Master initializer - delegates to set-specific initializers
        long cardCount = cardRepository.count();
        System.out.println("Current card count in database: " + cardCount);

        // Call initialization methods here once they are defined
        // e.g., st01Initializer.initialize();
        // ...
        // e.g., st21Initializer.initialize();

        System.out.println("Finished data initialization (placeholders for ST sets).");
    }
} 