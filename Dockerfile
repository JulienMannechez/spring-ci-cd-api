FROM openjdk:21-jdk-slim
WORKDIR /app
COPY target/spring-ci-cd-api.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
