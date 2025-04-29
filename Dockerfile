FROM maven:3.9.9-eclipse-temurin-17-alpine AS build

WORKDIR app

COPY pom.xml .
COPY src src
COPY config config

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim-buster

WORKDIR app

COPY --from=build app/target/rsmApp.jar /app

CMD ["java", "-jar", "/app/rsmApp.jar"]
