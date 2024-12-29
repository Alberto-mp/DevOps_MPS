# Usar una imagen base de Maven con JDK
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el código fuente al contenedor
COPY . /app

# Compilar y ejecutar pruebas
RUN mvn clean package

# Imagen final para ejecutar la aplicación (opcional)
FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]
