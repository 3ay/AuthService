FROM  adoptopenjdk/openjdk11:alpine-jre
LABEL authors="alex"
EXPOSE 8081
COPY target/AuthService-0.0.1-SNAPSHOT.jar authservice.jar
ENTRYPOINT ["java", "-jar", "authservice.jar"]