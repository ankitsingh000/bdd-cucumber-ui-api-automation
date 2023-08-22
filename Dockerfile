# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11 AS builder

FROM openjdk:11

# Install Maven
RUN apt-get update && apt-get install -y maven

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project's POM file
COPY pom.xml .



# Copy the entire project source code
COPY src ./src


# Use an official Selenium/Chrome image as the final image
FROM selenium/standalone-chrome:latest


# Copy the Chrome WebDriver executable
COPY chromedriver /usr/bin/

# Set the system property for the Chrome WebDriver
ENV WEBDRIVER_PATH=/usr/bin/chromedriver

# Build the project without running tests
RUN mvn package

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/bdd-cucumber-ui-api-automation-0.0.1-SNAPSHOT.jar /app/bdd-cucumber-ui-api-automation-0.0.1-SNAPSHOT.jar

# Set the entry point to run the Selenium tests
CMD ["java", "-Dwebdriver.chrome.driver=$WEBDRIVER_PATH", "-jar", "/app/bdd-cucumber-ui-api-automation-0.0.1-SNAPSHOT.jar"]
