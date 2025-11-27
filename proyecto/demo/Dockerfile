# Usamos Eclipse Temurin (la versión estándar actual de Java 21)
FROM eclipse-temurin:21-jdk

WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
EXPOSE 8080
CMD ["sh", "-c", "java -jar target/*.jar"]