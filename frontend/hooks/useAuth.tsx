"use client";

import React, { createContext, useContext, useState, useEffect, ReactNode } from 'react';
import { fetchApi } from '@/lib/api';

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
                const userData = await fetchApi<{ username: string }>('auth/me');
                setUser(userData);
            } catch (error) {
                // Don't log error for 401 Unauthorized, it just means not logged in
                if (!(error instanceof Error && error.message.includes('401'))) {
                    console.error('Error fetching user:', error);
                }
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