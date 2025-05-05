/**
 * API utility for making consistent API calls
 */

// Base API path - this is relative so it uses Next.js rewrites
export const API_BASE = '/api';

/**
 * Get the full URL for an API endpoint
 * @param path The API path without the leading /api
 * @returns The full API URL
 */
export const getApiUrl = (path: string): string => {
  // Make sure path doesn't start with a slash if we're appending
  const sanitizedPath = path.startsWith('/') ? path.substring(1) : path;
  return `${API_BASE}/${sanitizedPath}`;
};

/**
 * Basic GET request to the API
 * @param endpoint The API endpoint (without /api)
 * @returns Promise with the parsed JSON response
 */
export async function fetchApi<T>(endpoint: string): Promise<T> {
  const response = await fetch(getApiUrl(endpoint), {
    credentials: 'include',
    cache: 'no-store',
  });
  
  if (!response.ok) {
    throw new Error(`API error: ${response.status} ${response.statusText}`);
  }
  
  return response.json() as Promise<T>;
}

/**
 * POST request to the API
 * @param endpoint The API endpoint (without /api)
 * @param data The data to send
 * @returns Promise with the parsed JSON response
 */
export async function postApi<T, U = any>(endpoint: string, data: U): Promise<T> {
  const response = await fetch(getApiUrl(endpoint), {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
    credentials: 'include',
    cache: 'no-store',
  });
  
  if (!response.ok) {
    throw new Error(`API error: ${response.status} ${response.statusText}`);
  }
  
  return response.json() as Promise<T>;
}

/**
 * PUT request to the API
 * @param endpoint The API endpoint (without /api)
 * @param data The data to send
 * @returns Promise with the parsed JSON response
 */
export async function putApi<T, U = any>(endpoint: string, data: U): Promise<T> {
  const response = await fetch(getApiUrl(endpoint), {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
    credentials: 'include',
    cache: 'no-store',
  });
  
  if (!response.ok) {
    throw new Error(`API error: ${response.status} ${response.statusText}`);
  }
  
  return response.json() as Promise<T>;
}

/**
 * DELETE request to the API
 * @param endpoint The API endpoint (without /api)
 * @returns Promise with the parsed JSON response
 */
export async function deleteApi<T>(endpoint: string): Promise<T> {
  const response = await fetch(getApiUrl(endpoint), {
    method: 'DELETE',
    credentials: 'include',
    cache: 'no-store',
  });
  
  if (!response.ok) {
    throw new Error(`API error: ${response.status} ${response.statusText}`);
  }
  
  return response.json() as Promise<T>;
} 