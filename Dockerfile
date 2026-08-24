# Stage 1: Build stage using Maven and Java 17
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app

# Copy pom.xml and source code into the container
COPY app/pom.xml .
COPY app/src ./src

# Package the Spring Boot application into a JAR file without running tests
RUN mvn clean package -DskipTests

# Stage 2: Runtime stage using lightweight OpenJDK 17 image
FROM openjdk:17-jdk-slim
WORKDIR /app

# Copy the built JAR artifact from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose server port 8080
EXPOSE 8080

# Specify default executable command to launch the application
ENTRYPOINT ["java", "-jar", "app.jar"]
