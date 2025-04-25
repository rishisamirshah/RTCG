# Stage 1: Build the application using Maven
FROM eclipse-temurin:17-jdk-jammy as builder

WORKDIR /app

# Copy the Maven wrapper files
COPY .mvn/ .mvn
COPY mvnw .

# Copy pom.xml and download dependencies using the wrapper
COPY pom.xml .
RUN ./mvnw dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Package the application using the wrapper
RUN ./mvnw package -DskipTests -B

# Stage 2: Create the final lightweight image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/card-manager-0.0.1-SNAPSHOT.jar ./app.jar

# Expose the port the application runs on (using the environment variable is better)
# EXPOSE ${PORT:8080} # Optional: Render handles port exposure

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"] 