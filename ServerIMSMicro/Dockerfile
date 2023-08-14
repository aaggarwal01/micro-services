# Use the OpenJDK 11 as the base image
FROM openjdk:17


# Set the working directory to /app
WORKDIR /app


# Add a volume at /tmp
VOLUME ["/tmp"]


# Copy the JAR file from the target directory to the /app directory in the container
COPY target/*.jar app.jar


# Set the entrypoint to run the JAR file
ENTRYPOINT ["java","-jar","/app/app.jar"]
EXPOSE 8082