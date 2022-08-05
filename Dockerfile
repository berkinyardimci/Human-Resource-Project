FROM openjdk:8
EXPOSE 8080
COPY /target/hrms-0.0.1-SNAPSHOT.jar app.jar
CMD [ "java", "-jar", "app.jar" ]


