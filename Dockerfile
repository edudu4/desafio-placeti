FROM openjdk:17-jdk

LABEL maintainer="eduardoa8142@gmail.com"

COPY target/desafio-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]