FROM openjdk:17
LABEL authors="abhinavmaharana, srishtinagarkoti"
VOLUME /tmp
COPY target/BookMyShowPlatformService-0.0.1-SNAPSHOT.jar BookMyShowPlatformService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/BookMyShowPlatformService-0.0.1-SNAPSHOT.jar"]