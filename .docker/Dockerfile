FROM gradle:jdk15 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM adoptopenjdk:15-jre-hotspot

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/simple-java-web-services.jar

RUN echo $DATABASE_HOST $DATABASE_NAME $DATABASE_USERNAME $DATABASE_PASSWORD

ENTRYPOINT ["java", "-Xmx2g", "-XX:+UnlockExperimentalVMOptions", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/simple-java-web-services.jar"]
