# Use the official OpenJDK base image for Java 17
FROM openjdk:17

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
COPY target/SyntheticVehicleDataGenerator-0.0.1-SNAPSHOT.jar  /app/SyntheticVehicleDataGenerator-0.0.1-SNAPSHOT.jar

# Expose port 8080
EXPOSE 8080

# Define the command to run your Java application
CMD ["java", "-jar", "SyntheticVehicleDataGenerator-0.0.1-SNAPSHOT.jar"]
