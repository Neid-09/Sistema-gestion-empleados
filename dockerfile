FROM maven:3.9.4-eclipse-temurin-21 AS build

# Creamos el directorio de trabajo
WORKDIR /app

# Copiamos el archivo pom.xml y descargamos las dependencias
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copiamos el código fuente y construimos el proyecto
COPY src ./src
RUN mvn clean package -DskipTests

# Verificamos que el archivo JAR se ha creado correctamente
RUN ls -la /app/target

# Etapa final: Construimos la imagen con el JAR generado
FROM eclipse-temurin:21-jdk-alpine

# Creamos el directorio de trabajo
WORKDIR /app

# Copiamos el JAR generado desde la etapa de construcción
# Asegúrate de que el nombre del JAR coincide con el generado por tu proyecto
COPY --from=build /app/target/gest-empl-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponemos el puerto en el que la aplicación escuchará
EXPOSE 8080

# Definimos el comando de inicio de la aplicación
ENTRYPOINT [ "java", "-jar", "/app/app.jar" ]