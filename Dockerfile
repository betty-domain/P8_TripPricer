FROM openjdk:8-jdk-alpine
COPY build/libs/*.jar tripPricer.jar
ENTRYPOINT ["java","-jar","/tripPricer.jar"]