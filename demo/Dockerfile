#Build stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /build
COPY pom.xml .
RUN ["mvn", "dependency:go-offline"]
COPY src ./src
RUN ["mvn", "clean","package","-DskipTests"]

#Runtime stage
FROM amazoncorretto:17
ARG APP_VERSION=0.1.0
WORKDIR /app
COPY --from=build /build/target/demo-*.jar /app/
EXPOSE 8080

ENV JAR_VERSION=${APP_VERSION}
ENTRYPOINT ["sh", "-c", "java -jar demo-${JAR_VERSION}.jar"]