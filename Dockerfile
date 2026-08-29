FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/jenkins-demo-*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
