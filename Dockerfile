# Use an official Maven image as the base image
FROM maven:3.8.4-openjdk-11 AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project's POM file
COPY pom.xml .



# Copy the entire project source code
COPY src ./src

# Build the project without running tests
RUN mvn package -DskipTests
# Use an official Selenium/Chrome image as the final image
FROM selenium/standalone-chrome:latest

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/bdd-cucumber-ui-api-automation-0.0.1-SNAPSHOT.jar /app/bdd-cucumber-ui-api-automation-0.0.1-SNAPSHOT.jar
RUN apt-get update
RUN apt-get install -y wget unzip


# Download ChromeDriver and place it in /usr/bin
RUN wget -qO /tmp/chromedriver.zip https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/116.0.5845.96/linux64/chromedriver-linux64.zip && \
    unzip /tmp/chromedriver.zip -d /usr/bin && \
    chmod +x /usr/bin/chromedriver && \
    rm /tmp/chromedriver.zip

# Set the system property for the Chrome WebDriver
ENV WEBDRIVER_PATH=/usr/bin/chromedriver

# Set the entry point to run the Selenium tests
CMD ["java", "-Dwebdriver.chrome.driver=$WEBDRIVER_PATH", "-jar", "/app/bdd-cucumber-ui-api-automation-0.0.1-SNAPSHOT.jar"]
# Run the tests using Maven
RUN mvn test