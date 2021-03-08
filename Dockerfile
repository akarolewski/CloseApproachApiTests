FROM maven:3.6-jdk-11-slim

WORKDIR /app
COPY . /app

CMD mvn clean gatling:test