FROM openjdk:11
ADD target/prueba-0.0.1-SNAPSHOT.jar prueba-0.0.1-SNAPSHOT.jar
EXPOSE 8080
CMD ["java", "-jar", "prueba-0.0.1-SNAPSHOT.jar"]
