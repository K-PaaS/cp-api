FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} paas-ta-container-platform-api.jar
ENTRYPOINT ["java","-jar","/paas-ta-container-platform-api.jar"]
