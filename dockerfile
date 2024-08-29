FROM eclipse-temurin:17-jdk-alpine
COPY e-commerce/shop/target/app1.jar /app1.jar
ENTRYPOINT ["java","-jar","/app1.jar"]
EXPOSE 8080