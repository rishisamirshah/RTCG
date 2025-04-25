"use client";

import { useEffect, useState } from 'react';
import { useRouter } from 'next/navigation';
import Link from 'next/link';
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Label } from "@/components/ui/label";
import { Card, CardContent, CardDescription, CardFooter, CardHeader, CardTitle } from "@/components/ui/card";
import { motion } from 'framer-motion';

// Replace the cardBackgroundData with a smaller, more organized set
const backgroundCards = [
    // First row (top)
    { rotation: '-4deg', x: '20%', y: '10%', delay: 0.2, scale: 0.6, imagePath: '/images/cards/OP01/OP01-001.png', orientation: 'portrait' },
    { rotation: '3deg', x: '50%', y: '12%', delay: 0.5, scale: 0.55, imagePath: '/images/cards/OP01/OP01-002.png', orientation: 'landscape' },
    { rotation: '-2deg', x: '80%', y: '10%', delay: 0.3, scale: 0.65, imagePath: '/images/cards/OP01/OP01-003.png', orientation: 'portrait' },
    
    // Second row
    { rotation: '2deg', x: '15%', y: '30%', delay: 0.4, scale: 0.55, imagePath: '/images/cards/OP01/OP01-004.png', orientation: 'landscape' },
    { rotation: '-3deg', x: '45%', y: '32%', delay: 0.7, scale: 0.6, imagePath: '/images/cards/OP01/OP01-005.png', orientation: 'portrait' },
    { rotation: '4deg', x: '75%', y: '28%', delay: 0.2, scale: 0.58, imagePath: '/images/cards/OP01/OP01-006.png', orientation: 'landscape' },
    
    // Third row (middle)
    { rotation: '-2deg', x: '25%', y: '50%', delay: 0.3, scale: 0.63, imagePath: '/images/cards/OP01/OP01-007.png', orientation: 'portrait' },
    { rotation: '3deg', x: '60%', y: '48%', delay: 0.5, scale: 0.57, imagePath: '/images/cards/OP01/OP01-008.png', orientation: 'landscape' },
    { rotation: '-4deg', x: '85%', y: '52%', delay: 0.1, scale: 0.64, imagePath: '/images/cards/OP01/OP01-009.png', orientation: 'portrait' },
    
    // Fourth row
    { rotation: '4deg', x: '18%', y: '70%', delay: 0.6, scale: 0.61, imagePath: '/images/cards/OP01/OP01-010.png', orientation: 'landscape' },
    { rotation: '-3deg', x: '50%', y: '72%', delay: 0.2, scale: 0.56, imagePath: '/images/cards/OP01/OP01-011.png', orientation: 'portrait' },
    { rotation: '5deg', x: '82%', y: '68%', delay: 0.7, scale: 0.6, imagePath: '/images/cards/OP01/OP01-012.png', orientation: 'landscape' },
    
    // Fifth row (bottom)
    { rotation: '-3deg', x: '30%', y: '90%', delay: 0.5, scale: 0.57, imagePath: '/images/cards/OP01/OP01-013.png', orientation: 'portrait' },
    { rotation: '3deg', x: '70%', y: '88%', delay: 0.1, scale: 0.62, imagePath: '/images/cards/OP01/OP01-014.png', orientation: 'landscape' }
];

export default function LoginPage() {
    const router = useRouter();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const [isLoading, setIsLoading] = useState(false);
    const [mounted, setMounted] = useState(false);

    // Handle SSR
    useEffect(() => {
        setMounted(true);
    }, []);

    // Handle form submission
    const handleSubmit = async (e: React.FormEvent) => {
        e.preventDefault();
        setIsLoading(true);
        setError('');
        
        try {
            const response = await fetch('http://localhost:8080/api/auth/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: new URLSearchParams({
                    'username': username,
                    'password': password,
                }),
                credentials: 'include', // Important for cookies
            });
            
            if (response.ok) {
                // Parse the JSON response
                const data = await response.json();
                if (data.success) {
                    // Successful login
                    router.push('/dashboard'); // Redirect to dashboard or home page
                } else {
                    // This shouldn't happen with our backend, but just in case
                    setError(data.message || 'Login failed. Please try again.');
                }
            } else {
                // Handle unauthorized or other error status
                if (response.status === 401) {
                    setError('Invalid username or password');
                } else {
                    const errorData = await response.json().catch(() => null);
                    setError(errorData?.message || 'An error occurred. Please try again.');
                }
            }
        } catch (err) {
            console.error('Login error:', err);
            setError('An error occurred during login. Please try again.');
        } finally {
            setIsLoading(false);
        }
    };

    if (!mounted) {
        return null;
    }

    return (
        <div className="relative min-h-screen w-full overflow-hidden flex items-center justify-center bg-gradient-to-br from-gray-900 via-red-900 to-gray-900">
            {/* Add a full-width container for the content */}
            <div className="absolute inset-0 flex items-center justify-center">
                {/* Add multiple large glow effects positioned around the page */}
                <div className="absolute top-1/3 left-1/4 w-[800px] h-[800px] bg-red-600 rounded-full opacity-10 blur-[150px]"></div>
                <div className="absolute bottom-1/4 right-1/4 w-[600px] h-[600px] bg-red-800 rounded-full opacity-10 blur-[120px]"></div>
                <div className="absolute top-2/3 right-1/3 w-[400px] h-[400px] bg-yellow-600 rounded-full opacity-5 blur-[100px]"></div>
            </div>

            {/* Update animated background to cover the entire viewport */}
            <div className="absolute inset-0 p-20 overflow-hidden">
                {backgroundCards.map((card, index) => (
                    <motion.div
                        key={index}
                        className="absolute rounded-lg overflow-hidden shadow-xl"
                        style={{
                            // Position cards with percentage-based positions and transform to center
                            left: card.x,
                            top: card.y,
                            // Center the card at its position
                            transform: `translate(-50%, -50%) rotate(${card.rotation})`, 
                            scale: card.scale,
                            // Use proper card dimensions with 5:7 aspect ratio (standard card ratio)
                            width: '160px',
                            height: '224px',
                            transformOrigin: 'center center',
                            // Improved shadow for depth
                            boxShadow: '0 10px 30px -5px rgba(0, 0, 0, 0.3)',
                            // Add a colored background as immediate fallback
                            backgroundColor: `hsl(${index * 30}, 70%, 35%)`,
                        }}
                        // Simple initial state
                        initial={{ 
                            opacity: 0
                        }}
                        // Clean animation with simple float - increased movement and reduced duration
                        animate={{ 
                            y: [0, -20, 0], // Increased movement range from -15 to -20
                            opacity: [0.12, 0.22, 0.12], // Slightly increased opacity range
                            rotate: [
                                card.rotation,
                                `${parseFloat(card.rotation) + (index % 2 === 0 ? 1.5 : -1.5)}deg`, // Slightly increased rotation
                                card.rotation
                            ]
                        }}
                        transition={{
                            y: {
                                repeat: Infinity,
                                duration: 5 + (index % 3), // Reduced from 7 to 5 seconds base duration
                                ease: "easeInOut",
                                times: [0, 0.5, 1]
                            },
                            opacity: {
                                repeat: Infinity,
                                duration: 5 + (index % 3), // Reduced duration
                                ease: "easeInOut",
                                times: [0, 0.5, 1]
                            },
                            rotate: {
                                repeat: Infinity,
                                duration: 5 + (index % 3), // Reduced duration
                                ease: "easeInOut", 
                                times: [0, 0.5, 1]
                            },
                            delay: card.delay,
                        }}
                    >
                        {/* Card image with proper styling */}
                        <img 
                            src={card.imagePath} 
                            alt="One Piece Card" 
                            className="w-full h-full object-cover"
                            loading="lazy"
                            onError={(e) => {
                                // Hide the image element if it fails to load
                                e.currentTarget.style.display = 'none';
                                // Make the parent more visible as a fallback
                                e.currentTarget.parentElement!.style.backgroundColor = `hsl(${index * 30}, 85%, 40%)`;
                            }}
                        />
                        
                        {/* Enhanced card styling */}
                        <div className="absolute inset-0 bg-gradient-to-b from-white/25 to-transparent pointer-events-none"></div>
                        <div className="absolute bottom-2 left-2 right-2 h-2 bg-white/15 rounded"></div>
                        
                        {/* Add subtle shine effect */}
                        <div className="absolute inset-0 bg-gradient-to-tr from-transparent via-white/5 to-transparent pointer-events-none"></div>
                    </motion.div>
                ))}
            </div>

            {/* Extend the pattern overlay to the entire viewport */}
            <div className="absolute inset-0 bg-[url('/images/card-pattern.png')] opacity-10"></div>

            {/* Update the login card container to be responsive but centered */}
            <motion.div
                initial={{ opacity: 0, y: 20 }}
                animate={{ opacity: 1, y: 0 }}
                transition={{ duration: 0.5 }}
                className="z-10 px-4 w-full max-w-md mx-auto"
            >
                <Card className="w-full backdrop-blur-md bg-black/30 border border-white/10 shadow-2xl rounded-xl overflow-hidden">
                    <div className="absolute top-0 left-0 right-0 h-1 bg-gradient-to-r from-red-500 via-yellow-500 to-red-500"></div>
                    
                    <CardHeader className="space-y-1 pb-2">
                        <CardTitle className="text-2xl font-bold text-center text-white">
                            Welcome Back
                        </CardTitle>
                        <CardDescription className="text-center text-gray-300">
                            Enter your credentials to access your collection
                        </CardDescription>
                </CardHeader>
                    
                    <CardContent className="pt-4">
                    <form onSubmit={handleSubmit} className="space-y-4">
                        <div className="space-y-2">
                                <Label htmlFor="username" className="text-gray-200">Username</Label>
                            <Input
                                id="username"
                                name="username"
                                type="text"
                                placeholder="Enter your username"
                                required
                                value={username}
                                onChange={(e) => setUsername(e.target.value)}
                                className="bg-white/10 border-white/20 text-white placeholder:text-gray-400"
                            />
                        </div>
                            
                        <div className="space-y-2">
                                <Label htmlFor="password" className="text-gray-200">Password</Label>
                            <Input
                                id="password"
                                name="password"
                                type="password"
                                placeholder="Enter your password"
                                required
                                value={password}
                                onChange={(e) => setPassword(e.target.value)}
                                className="bg-white/10 border-white/20 text-white placeholder:text-gray-400"
                            />
                        </div>
                            
                            {error && (
                                <motion.div
                                    initial={{ opacity: 0, y: -10 }}
                                    animate={{ opacity: 1, y: 0 }}
                                    className="rounded-md bg-red-900/50 p-3 border border-red-500/50"
                                >
                                    <p className="text-sm text-red-200 text-center">{error}</p>
                                </motion.div>
                            )}
                            
                            <Button 
                                type="submit" 
                                disabled={isLoading}
                                className="w-full bg-gradient-to-r from-red-600 to-red-700 hover:from-red-500 hover:to-red-600 text-white border-none"
                            >
                                {isLoading ? 'Logging in...' : 'Log In'}
                            </Button>
                            
                            <div className="relative my-4">
                                <div className="absolute inset-0 flex items-center">
                                    <span className="w-full border-t border-white/10"></span>
                                </div>
                                <div className="relative flex justify-center text-xs uppercase">
                                    <span className="px-2 bg-black/30 text-gray-400">Or</span>
                                </div>
                            </div>
                        </form>
                    </CardContent>
                    
                    <CardFooter className="flex flex-col space-y-4 pt-0">
                        <Button 
                            variant="outline" 
                            className="w-full bg-transparent border border-white/10 text-white hover:bg-white/5"
                            onClick={() => router.push('/register')}
                        >
                            Create Account
                        </Button>
                        
                        <p className="text-center text-sm text-gray-400 px-6">
                            By logging in, you accept our <a className="text-red-400 hover:text-red-300 underline transition-colors" href="#terms">Terms of Service</a> and <a className="text-red-400 hover:text-red-300 underline transition-colors" href="#privacy">Privacy Policy</a>
                        </p>
                </CardFooter>
            </Card>
            </motion.div>
        </div>
    );
} 