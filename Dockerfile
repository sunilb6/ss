# ==========================
# STAGE 1: Build the JAR File
# ==========================
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

# Copy necessary files for dependency resolution first (faster builds)
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .

RUN dos2unix gradlew

# Ensure gradlew is executable
RUN chmod +x gradlew

# Download dependencies (helps with caching)
RUN ./gradlew dependencies --no-daemon
#CMD ["./gradlew", "dependencies"]

# Copy source code
COPY src src

# Build the application
RUN ./gradlew build --no-daemon

# ==========================
# STAGE 2: Create the Final Image
# ==========================
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

RUN echo "After chmod, listing files again:" && ls -lah /app

# Copy only the built JAR file from the previous stage
COPY --from=build /app/build/libs/ss-1.0.jar ss-1.0.jar

# Expose application port
EXPOSE 8081

# Run the Spring Boot application
CMD ["java", "-jar", "ss-1.0.jar"]
#RUN java -jar app.jar
