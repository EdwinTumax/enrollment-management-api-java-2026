FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY target/enrollment-management-api-0.0.1-SNAPSHOT.jar enrollment-management-api-1.0.0.jar
ENTRYPOINT ["java","-jar", "enrollment-management-api-1.0.0.jar"]
EXPOSE 9080