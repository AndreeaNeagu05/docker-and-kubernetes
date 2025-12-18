# Use a JDK 21 runtime image
FROM eclipse-temurin:21-jre

# Workdir inside container
WORKDIR /app

# Copy the jar built by Maven
COPY target/docker-and-kubernetes-1.0-SNAPSHOT.jar app.jar

# Expose the app port
EXPOSE 8080

# Start the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]