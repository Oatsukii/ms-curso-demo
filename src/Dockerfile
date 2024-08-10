FROM openjdk:21-slim

#FROM mcr.microsoft.com/openjdk/jdk:21-ubuntu

WORKDIR /app
#COPY target/ms-curso-demo-snapchsot.jar .
COPY target/*.jar app.jar
CMD ["java", ".jar", "app.jar"]