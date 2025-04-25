"use client"

import React from 'react';
import {
    BarChart,
    Bar,
    XAxis,
    YAxis,
    CartesianGrid,
    Tooltip,
    ResponsiveContainer,
    Cell,
    LabelList
} from 'recharts';
import { Card } from '@/components/ui/card';
import { Badge } from '@/components/ui/badge';
import { Card as CardType } from '@/lib/types'; // Corrected import alias
import { ScrollArea } from '@/components/ui/scroll-area';

// Define data structure for charts
interface ChartDataPoint {
    name: string;
    count: number;
}

interface DeckStatsProps {
    costCurveData: ChartDataPoint[];
    powerCurveData: ChartDataPoint[];
    attributeData: ChartDataPoint[];
    typeData: { name: string; count: number }[]; // Affiliations/Traits
    // Add keyword data later if implemented
}

// Define colors for charts - using red theme instead of blue
const CHART_COLORS = {
    primary: "#ef4444", // red-500
    secondary: "#dc2626", // red-600
    tertiary: "#b91c1c", // red-700
    background: "#fee2e2", // red-100
    text: "#991b1b" // red-800
};

// Custom tooltip component for better styling
const CustomTooltip = ({ active, payload, label }: any) => {
    if (active && payload && payload.length) {
        return (
            <div className="custom-tooltip bg-white dark:bg-gray-800 p-2 border border-gray-200 dark:border-gray-700 rounded-md shadow-md">
                <p className="font-semibold text-xs dark:text-gray-100">{`${label}`}</p>
                <p className="text-xs text-red-600 dark:text-red-400">{`Count: ${payload[0].value}`}</p>
            </div>
        );
    }
    return null;
};

export const DeckStats: React.FC<DeckStatsProps> = ({ costCurveData, powerCurveData, attributeData, typeData }) => {
    return (
        <Card className="mt-4 p-4 bg-card border border-gray-300 dark:border-gray-700 shadow-lg rounded-xl overflow-hidden">
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4">
                {/* Cost Curve */}
                <div className="col-span-1 bg-gradient-to-br from-white to-red-50 dark:from-gray-800 dark:to-gray-900 p-3 rounded-lg shadow-sm hover:shadow-md transition-shadow">
                    <h3 className="text-center font-semibold mb-2 text-sm text-red-800 dark:text-red-400">Cost Curve</h3>
                    <ResponsiveContainer width="100%" height={150}>
                        <BarChart data={costCurveData} margin={{ top: 5, right: 5, left: -25, bottom: 5 }}>
                            <CartesianGrid strokeDasharray="3 3" stroke="#e5e7eb" opacity={0.5} />
                            <XAxis 
                                dataKey="name" 
                                fontSize={10} 
                                tickLine={false} 
                                axisLine={false}
                                tick={{ fill: '#6b7280' }}
                                className="dark:text-gray-300"
                            />
                            <YAxis 
                                allowDecimals={false} 
                                fontSize={10} 
                                width={30} 
                                tickLine={false} 
                                axisLine={false}
                                tick={{ fill: '#6b7280' }}
                                className="dark:text-gray-300"
                            />
                            <Tooltip content={<CustomTooltip />} cursor={{ fill: 'rgba(239, 68, 68, 0.1)' }} />
                            <defs>
                                <linearGradient id="costGradient" x1="0" y1="0" x2="0" y2="1">
                                    <stop offset="0%" stopColor={CHART_COLORS.primary} stopOpacity={1} />
                                    <stop offset="100%" stopColor={CHART_COLORS.secondary} stopOpacity={0.8} />
                                </linearGradient>
                            </defs>
                            <Bar 
                                dataKey="count" 
                                fill="url(#costGradient)" 
                                radius={[4, 4, 0, 0]}
                                animationDuration={1500}
                                animationEasing="ease-out" 
                            >
                                {costCurveData.map((entry, index) => (
                                    <Cell 
                                        key={`cell-${index}`}
                                        style={{filter: 'drop-shadow(0px 1px 2px rgba(0, 0, 0, 0.1))'}}
                                    />
                                ))}
                            </Bar>
                        </BarChart>
                    </ResponsiveContainer>
                </div>

                {/* Power Curve */}
                <div className="col-span-1 bg-gradient-to-br from-white to-red-50 dark:from-gray-800 dark:to-gray-900 p-3 rounded-lg shadow-sm hover:shadow-md transition-shadow">
                     <h3 className="text-center font-semibold mb-2 text-sm text-red-800 dark:text-red-400">Power Curve</h3>
                     <ResponsiveContainer width="100%" height={150}>
                        <BarChart data={powerCurveData} margin={{ top: 5, right: 5, left: -25, bottom: 5 }}>
                            <CartesianGrid strokeDasharray="3 3" stroke="#e5e7eb" opacity={0.5} />
                            <XAxis 
                                dataKey="name" 
                                fontSize={10} 
                                tickLine={false} 
                                axisLine={false}
                                tick={{ fill: '#6b7280' }}
                                className="dark:text-gray-300"
                            />
                            <YAxis 
                                allowDecimals={false} 
                                fontSize={10} 
                                width={30} 
                                tickLine={false} 
                                axisLine={false}
                                tick={{ fill: '#6b7280' }}
                                className="dark:text-gray-300"
                            />
                            <Tooltip content={<CustomTooltip />} cursor={{ fill: 'rgba(239, 68, 68, 0.1)' }} />
                            <defs>
                                <linearGradient id="powerGradient" x1="0" y1="0" x2="0" y2="1">
                                    <stop offset="0%" stopColor={CHART_COLORS.secondary} stopOpacity={1} />
                                    <stop offset="100%" stopColor={CHART_COLORS.tertiary} stopOpacity={0.8} />
                                </linearGradient>
                            </defs>
                            <Bar 
                                dataKey="count" 
                                fill="url(#powerGradient)" 
                                radius={[4, 4, 0, 0]}
                                animationDuration={1500}
                                animationEasing="ease-out"
                            >
                                {powerCurveData.map((entry, index) => (
                                    <Cell 
                                        key={`cell-${index}`}
                                        style={{filter: 'drop-shadow(0px 1px 2px rgba(0, 0, 0, 0.1))'}}
                                    />
                                ))}
                            </Bar>
                        </BarChart>
                    </ResponsiveContainer>
                </div>

                 {/* Attribute Curve */}
                 <div className="col-span-1 bg-gradient-to-br from-white to-red-50 dark:from-gray-800 dark:to-gray-900 p-3 rounded-lg shadow-sm hover:shadow-md transition-shadow">
                     <h3 className="text-center font-semibold mb-2 text-sm text-red-800 dark:text-red-400">Attribute</h3>
                     <ResponsiveContainer width="100%" height={150}>
                        <BarChart data={attributeData} margin={{ top: 5, right: 5, left: -25, bottom: 5 }}>
                             <CartesianGrid strokeDasharray="3 3" stroke="#e5e7eb" opacity={0.5} />
                            <XAxis 
                                dataKey="name" 
                                fontSize={10} 
                                tickLine={false} 
                                axisLine={false}
                                tick={{ fill: '#6b7280' }}
                                className="dark:text-gray-300"
                            />
                            <YAxis 
                                allowDecimals={false} 
                                fontSize={10} 
                                width={30} 
                                tickLine={false} 
                                axisLine={false}
                                tick={{ fill: '#6b7280' }}
                                className="dark:text-gray-300"
                            />
                            <Tooltip content={<CustomTooltip />} cursor={{ fill: 'rgba(239, 68, 68, 0.1)' }} />
                            <defs>
                                <linearGradient id="attrGradient" x1="0" y1="0" x2="0" y2="1">
                                    <stop offset="0%" stopColor={CHART_COLORS.tertiary} stopOpacity={1} />
                                    <stop offset="100%" stopColor={CHART_COLORS.text} stopOpacity={0.8} />
                                </linearGradient>
                            </defs>
                            <Bar 
                                dataKey="count" 
                                fill="url(#attrGradient)" 
                                radius={[4, 4, 0, 0]}
                                animationDuration={1500}
                                animationEasing="ease-out"
                            >
                                {attributeData.map((entry, index) => (
                                    <Cell 
                                        key={`cell-${index}`}
                                        style={{filter: 'drop-shadow(0px 1px 2px rgba(0, 0, 0, 0.1))'}}
                                    />
                                ))}
                                <LabelList dataKey="count" position="top" fontSize={9} fill="#6b7280" className="dark:text-gray-300" />
                            </Bar>
                        </BarChart>
                    </ResponsiveContainer>
                </div>

                {/* Types (Affiliations) */}
                <div className="col-span-1 bg-gradient-to-br from-white to-red-50 dark:from-gray-800 dark:to-gray-900 p-3 rounded-lg shadow-sm hover:shadow-md transition-shadow">
                    <h3 className="text-center font-semibold mb-2 text-sm text-red-800 dark:text-red-400">Types</h3>
                    <ScrollArea className="h-[150px] w-full px-1">
                         <div className="flex flex-col items-stretch space-y-1">
                            {typeData.length > 0 ? (
                                typeData.sort((a, b) => b.count - a.count).map(type => (
                                    <Badge 
                                        key={type.name} 
                                        variant="outline" 
                                        className="w-full text-left text-xs font-normal px-2 py-1 bg-white dark:bg-gray-800 border-red-200 dark:border-red-900 hover:bg-red-50 dark:hover:bg-red-900/30 transition-colors"
                                    >
                                        <span className="inline-block w-6 h-6 mr-2 rounded-full bg-gradient-to-r from-red-500 to-red-700 text-white text-center font-bold leading-6">
                                            {type.count}
                                        </span>
                                        <span className="whitespace-nowrap overflow-hidden text-ellipsis">{type.name}</span>
                                    </Badge>
                                ))
                            ) : (
                                <p className="text-xs text-gray-500 dark:text-gray-400 text-center mt-4">No specific types</p>
                            )}
                        </div>
                    </ScrollArea>
                </div>
            </div>
        </Card>
    );
}; 