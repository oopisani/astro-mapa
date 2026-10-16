# Etapa 1: Construir o projeto (Build) com Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compila o projeto ignorando os testes
RUN mvn clean package -DskipTests

# Etapa 2: Rodar o projeto (Run)
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copia o .jar gerado na Etapa 1 para esta etapa
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]