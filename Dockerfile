FROM maven:3.6-jdk-11-slim

COPY . /app
WORKDIR /app

RUN mvn clean install
RUN mvn gatling:test