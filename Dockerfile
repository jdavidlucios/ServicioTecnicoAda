# Use an official Java runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the project’s pom.xml and mvnw files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Grant execution rights on the mvnw wrapper
RUN chmod +x ./mvnw

# Build the project and clean up afterwards
RUN ./mvnw dependency:resolve && \
    ./mvnw clean package -DskipTests && \
    rm -rf ~/.m2/repository && \
    rm -rf /app/target

# Copy the final jar file to the container
COPY target/*.jar app.jar

# (Optional) Set JAVA_HOME environment variable
# ENV JAVA_HOME=/usr/lib/jvm/java-17-openjdk

# Expose the port that the app will run on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/app/app.jar"]
