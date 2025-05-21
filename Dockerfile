# Etapa 1: Build con Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

WORKDIR /app

# Copia los archivos de configuración y código
COPY pom.xml .
COPY src ./src

# Construye el proyecto y genera el JAR
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la app con Java
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copia el JAR generado desde la etapa de build
COPY --from=build /app/target/boatShip-0.0.1-SNAPSHOT.jar ./app.jar

# Expone el puerto 8080 (o el que uses)
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar", "--server.port=8080"]
