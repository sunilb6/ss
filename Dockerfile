# Use a lightweight JDK base image
FROM eclipse-temurin:17-jdk-alpine AS build

# Set working directory inside the container
WORKDIR /app

# Copy Gradle wrapper and build files
COPY gradle gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .
COPY src src

# Grant execution permissions to Gradle wrapper
RUN chmod +x ./gradlew

# Build the Spring Boot application
RUN ./gradlew build --no-daemon

# Use a lightweight runtime image for the final container
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy only the built JAR file from the previous stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8087

# Set environment variables (if needed)
ENV SPRING_PROFILES_ACTIVE=stag

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]