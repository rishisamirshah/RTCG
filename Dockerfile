# Use OpenJDK 17 as the base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Copy the database file if it exists
COPY cards.db* ./

# Create volume for persistent data
VOLUME /app/data

# Environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV PORT=8080

# Expose the port
EXPOSE 8080

# Run the application
CMD ["java", "-jar", "app.jar"] 