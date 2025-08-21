# Etapa de construcción
FROM maven:3.9.5-eclipse-temurin-17-alpine AS build
WORKDIR /app

# Copiar solo los archivos necesarios para la instalación de dependencias
COPY pom.xml .
COPY src ./src

# Empaquetar la aplicación
RUN mvn clean package -DskipTests

# Etapa de producción
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiar el JAR de la etapa de construcción
COPY --from=build /app/target/*.jar app.jar

# Puerto expuesto (ajusta según tu configuración)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
