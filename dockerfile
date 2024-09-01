FROM eclipse-temurin:17-jdk-alpine
COPY shop/target/app1.jar /app1.jar
ENTRYPOINT ["java","-jar","/app1.jar"]
EXPOSE 443