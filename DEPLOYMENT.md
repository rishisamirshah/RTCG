# Deployment Guide: One Piece Card Collection

## Subdomain Setup

1. DNS Configuration
   - Create a new A record or CNAME for your subdomain:
     ```
     Type: A or CNAME
     Name: cards
     Value: [Your server IP or domain]
     TTL: 3600
     ```

2. SSL Certificate
   - Obtain a SSL certificate for your subdomain
   - Recommended: Use Let's Encrypt for free SSL
   ```bash
   certbot certonly --standalone -d cards.yourdomain.com
   ```

## Application Deployment

1. Build the Application
   ```bash
   mvn clean package -DskipTests
   ```

2. Docker Deployment
   ```bash
   # Build the Docker image
   docker build -t onepiece-cards .

   # Run the container
   docker run -d \
     --name onepiece-cards \
     -p 80:8080 \
     -v /path/to/ssl:/ssl \
     -e SSL_ENABLED=true \
     -e SSL_KEYSTORE=/ssl/keystore.p12 \
     -e SSL_PASSWORD=your_password \
     -e SPRING_PROFILES_ACTIVE=prod \
     onepiece-cards
   ```

3. Environment Variables
   - `PORT`: Application port (default: 8080)
   - `SSL_ENABLED`: Enable SSL (true/false)
   - `SSL_KEYSTORE`: Path to SSL keystore
   - `SSL_PASSWORD`: SSL keystore password
   - `SPRING_PROFILES_ACTIVE`: Set to 'prod'

## Shopify Integration

1. Update Your Shopify Theme
   - Add navigation link to your card collection:
   ```html
   <a href="https://cards.yourdomain.com" class="nav-link">Card Collection</a>
   ```

2. Update CORS Configuration
   - Edit `application-prod.properties`:
   ```properties
   spring.web.cors.allowed-origins=https://your-shopify-store.myshopify.com
   ```

## Maintenance

1. Database Backup
   ```bash
   # Create backup
   docker exec onepiece-cards cp /app/cards.db /app/data/cards.db.backup
   ```

2. Logs
   ```bash
   # View logs
   docker logs onepiece-cards
   ```

3. Updates
   ```bash
   # Pull latest code
   git pull

   # Rebuild and restart
   mvn clean package -DskipTests
   docker-compose down
   docker-compose up -d
   ```

## Monitoring

1. Health Check
   - Monitor: https://cards.yourdomain.com/actuator/health
   - Set up uptime monitoring (e.g., UptimeRobot)

2. Performance
   - Monitor server resources
   - Set up alerts for high CPU/memory usage

## Security

1. Firewall Configuration
   ```bash
   # Allow only necessary ports
   ufw allow 80
   ufw allow 443
   ufw allow 22
   ```

2. Regular Updates
   - Keep system packages updated
   - Monitor security advisories

## Troubleshooting

1. Application Issues
   - Check logs: `docker logs onepiece-cards`
   - Verify database connectivity
   - Check SSL certificate validity

2. Connection Issues
   - Verify DNS settings
   - Check firewall rules
   - Validate SSL configuration 