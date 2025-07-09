# Use Maven for building the project
FROM maven:3.9.2-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy mã nguồn ứng dụng Spring Boot vào thư mục /app trong stage tạm thời
COPY . /app

# Build the project
RUN mvn package -DskipTests

# check jar existed
RUN ls -la target

# Use OpenJDK for running the JAR
FROM openjdk:17

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/jimmysea.jar /jimmysea.jar

# Specify the command to run on container startup
ENTRYPOINT ["java", "-jar", "jimmysea.jar"]