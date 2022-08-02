FROM openjdk:8
EXPOSE 8080
COPY target/docker-0.0.1-SNAPSHOT.jar docker.jar
ENTRYPOINT [ "java", "-jar", "docker.jar" ]