let userConfig = undefined
try {
  // try to import ESM first
  userConfig = await import('./v0-user-next.config.mjs')
} catch (e) {
  try {
    // fallback to CJS import
    userConfig = await import("./v0-user-next.config");
  } catch (innerError) {
    // ignore error
  }
}

// Define the backend URL
const BACKEND_URL = process.env.BACKEND_URL || 'https://onepieceapp.onrender.com';

/** @type {import('next').NextConfig} */
const nextConfig = {
  eslint: {
    ignoreDuringBuilds: true,
  },
  typescript: {
    ignoreBuildErrors: true,
  },
  images: {
    domains: ['localhost', 'onepieceapp.onrender.com'],
    unoptimized: true,
    remotePatterns: [
      {
        protocol: 'https',
        hostname: 'onepieceapp.onrender.com',
        pathname: '/images/**',
      },
    ],
  },
  experimental: {
    instrumentationHook: true,
    parallelServerCompiles: true,
  },
  reactStrictMode: true,
  async rewrites() {
    console.log('Configuring rewrites for image paths');
    return [
      {
        source: '/images/:path*',
        destination: `${BACKEND_URL}/images/:path*`, // Proxy to deployed backend
      },
      {
        source: '/api/:path*',
        destination: `${BACKEND_URL}/api/:path*`, // Proxy API requests
      },
    ]
  },
  // Enable more detailed logging for debugging
  logging: {
    fetches: {
      fullUrl: true,
    },
  },
}

if (userConfig) {
  // ESM imports will have a "default" property
  const config = userConfig.default || userConfig

  for (const key in config) {
    if (
      typeof nextConfig[key] === 'object' &&
      !Array.isArray(nextConfig[key])
    ) {
      nextConfig[key] = {
        ...nextConfig[key],
        ...config[key],
      }
    } else {
      nextConfig[key] = config[key]
    }
  }
}

export default nextConfig
