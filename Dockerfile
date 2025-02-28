# Use a lightweight base image with JDK (Java Development Kit)
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file into the container
COPY build/libs/ss-1.0.jar app.jar/

# Expose the port your Spring Boot app runs on
EXPOSE 8087

# Set environment variables (if needed)
ENV SPRING_PROFILES_ACTIVE=stag

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]