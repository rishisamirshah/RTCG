package com.onepiece.cardmanager.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;

/**
 * Abstract base class for all card initializers.
 * Provides common functionality to check if initialization is enabled.
 */
public abstract class BaseInitializer implements CommandLineRunner {

    @Value("${app.data.initialize:true}")
    private boolean initializeData;
    
    @Override
    public void run(String... args) throws Exception {
        if (!initializeData) {
            System.out.println("Data initialization is disabled. Skipping...");
            return;
        }
        
        // Call the implementation-specific initialize method
        initialize(args);
    }
    
    /**
     * Implement this method in concrete initializer classes to
     * perform the actual initialization.
     */
    protected abstract void initialize(String... args) throws Exception;
} 