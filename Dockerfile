FROM openjdk:14-jdk-alpine as build
COPY . /app
WORKDIR /app
RUN ./mvnw clean package -DskipTests

FROM openjdk:14-jdk-alpine
COPY --from=build /app/target/*.jar /app.jar
EXPOSE 8080
CMD ["java", "-jar", "/app.jar"]
