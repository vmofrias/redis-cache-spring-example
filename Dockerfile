FROM openjdk:17-jdk-slim

COPY ./target/caching-redis-0.0.1-SNAPSHOT.jar .

ENTRYPOINT java -jar caching-redis-0.0.1-SNAPSHOT.jar
