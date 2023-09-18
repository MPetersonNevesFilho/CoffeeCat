# Use uma imagem base com o Java e Maven instalados
FROM maven:3.8.4-openjdk-17-slim AS build

# Define o diretório de trabalho na imagem
WORKDIR /app

# Copia os arquivos de configuração e o arquivo pom.xml
COPY ./pom.xml ./pom.xml
COPY ./src ./src

# Compila o projeto usando Maven
RUN mvn clean package

# Segunda fase do Dockerfile, usando uma imagem mais leve para a execução
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho na imagem
WORKDIR /app

# Copia o arquivo JAR compilado da fase anterior
COPY --from=build /app/target/coffeeCat-0.0.1-SNAPSHOT.jar app.jar

# Comando para iniciar a aplicação
CMD ["java", "-jar", "app.jar"]
