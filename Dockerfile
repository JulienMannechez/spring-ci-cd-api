# Utilisation d'une image Maven pour builder le projet
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copier le projet et builder l'application
COPY . .
RUN mvn clean package -DskipTests

# Utilisation d'une image OpenJDK pour l'exécution
FROM openjdk:21-jdk-slim
WORKDIR /app

# Copier le .jar généré depuis le build précédent
COPY --from=build /app/target/*.jar app.jar

# Démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
