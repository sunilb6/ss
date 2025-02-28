# ==========================
# STAGE 1: Build the JAR File
# ==========================
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Install dos2unix (for Windows line ending issues)
RUN apk add --no-cache dos2unix

# Copy necessary files for dependency resolution first (optimizes caching)
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

# Convert Windows line endings (if any)
RUN dos2unix gradlew

# Ensure gradlew is executable
RUN chmod +x gradlew

# Copy source code
COPY src src

# Build the application
RUN ./gradlew bootJar --no-daemon

# Verify the JAR file was created
# RUN ls -lah build/libs

# ==========================
# STAGE 2: Create the Final Image
# ==========================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app


# Copy only the built JAR file from the previous stage
COPY --from=build /app/build/libs/ss-1.0.jar app.jar

RUN ls -lah /app

# Expose application port
EXPOSE 8081

# Run the Spring Boot application
CMD ["java", "-jar", "app.jar"]
