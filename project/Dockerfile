FROM openjdk:21-jdk
EXPOSE 8080
COPY ./build/libs/keycloak-project-0.0.1.jar /tmp/
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "keycloak-project-0.0.1.jar"]
