# Use Java 17 base image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy jar file from target folder
COPY target/*.jar app.jar

# Expose application port (Change this per service)
EXPOSE 8081

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
