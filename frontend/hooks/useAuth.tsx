"use client";

import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';

interface AuthContextType {
    user: { username: string } | null;
    isLoading: boolean;
    // Add login/logout functions here later if switching from form-based
}

const AuthContext = createContext<AuthContextType | undefined>(undefined);

export const AuthProvider: React.FC<{ children: ReactNode }> = ({ children }) => {
    const [user, setUser] = useState<{ username: string } | null>(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        const fetchUser = async () => {
            setIsLoading(true);
            try {
                // Fetch user info from the backend /me endpoint
                // Credentials should be sent automatically if cookies are set
                const response = await fetch('http://localhost:8080/api/auth/me', {
                    method: 'GET',
                    headers: {
                        // No explicit 'Authorization' needed for cookie/session auth
                        'Accept': 'application/json',
                    },
                    credentials: 'include', // Send cookies with the request
                });

                if (response.ok) {
                    const userData = await response.json();
                    setUser(userData); // Expects { username: "..." }
                } else {
                    setUser(null);
                    // Don't log error for 401 Unauthorized, it just means not logged in
                    if (response.status !== 401) {
                        console.error('Failed to fetch user:', response.statusText);
                    }
                }
            } catch (error) {
                console.error('Error fetching user:', error);
                setUser(null);
            } finally {
                setIsLoading(false);
            }
        };

        fetchUser();
    }, []); // Run only once on mount

    return (
        <AuthContext.Provider value={{ user, isLoading }}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = (): AuthContextType => {
    const context = useContext(AuthContext);
    if (context === undefined) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
}; 