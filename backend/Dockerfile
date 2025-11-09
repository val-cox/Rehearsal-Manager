# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy Maven wrapper and project files
COPY . .

# Build the application (skips tests)
RUN ./mvnw clean package -DskipTests

# Expose the app port
EXPOSE 8080

# Run the Spring Boot JAR
CMD ["java", "-jar", "target/RehearsalManager-0.0.1-SNAPSHOT.jar"]


