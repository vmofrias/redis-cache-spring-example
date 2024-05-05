#!/bin/sh


echo "Building the application and generating the jar file..."
mvn clean install

echo "Building the application's image..."
docker build -t local/app:1.0 .

echo "Running the docker-compose.yml..."
docker compose up



