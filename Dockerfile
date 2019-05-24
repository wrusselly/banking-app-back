FROM maven:latest as maven
WORKDIR /build
COPY ./bankEclipse .
RUN mvn clean package
FROM java:8
WORKDIR /opt/back-end
COPY --from=maven /build/target/Bank-app-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]
