FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/email-0.0.1-SNAPSHOT.war app.war
ENTRYPOINT ["java", "-jar", "/app.war"]
EXPOSE 8080
