# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project's POM file
COPY pom.xml .

# Download the Maven dependencies
RUN mvn dependency:go-offline

# Copy the entire project source code
COPY src ./src

# Run the tests using Maven
RUN mvn test

# Use an official Selenium/Chrome image as the final image
FROM selenium/standalone-chrome:latest

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/bdd-cucumber-ui-api-automation-remote.jar /app/bdd-cucumber-ui-api-automation-remote.jar

# Copy the Chrome WebDriver executable
COPY chromedriver /usr/bin/chromedriver
RUN chmod +x /usr/bin/chromedriver

# Set the system property for the Chrome WebDriver
ENV WEBDRIVER_PATH=/usr/bin/chromedriver

# Set the entry point to run the Selenium tests
CMD ["java", "-Dwebdriver.chrome.driver=$WEBDRIVER_PATH", "-jar", "/app/bdd-cucumber-ui-api-automation-remote.jar"]