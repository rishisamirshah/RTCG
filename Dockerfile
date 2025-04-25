# Stage 1: Build the application
FROM maven:3.9-eclipse-temurin-17 as builder

WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy the rest of the source code
COPY src ./src

# Package the application
RUN mvn package -DskipTests -B

# Stage 2: Create the final lightweight image
FROM eclipse-temurin:17-jre-jammy

WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/card-manager-0.0.1-SNAPSHOT.jar ./app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"] 