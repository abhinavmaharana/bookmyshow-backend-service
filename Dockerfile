FROM openjdk:17
LABEL authors="abhinavmaharana, srishtinagarkoti"
ADD target/BookMyShowPlatformService-0.0.1-SNAPSHOT.jar BookMyShowPlatformService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/BookMyShowPlatformService-0.0.1-SNAPSHOT.jar"]