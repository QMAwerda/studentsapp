FROM openjdk:17-jdk-alpine AS build
COPY target/springstudents-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
