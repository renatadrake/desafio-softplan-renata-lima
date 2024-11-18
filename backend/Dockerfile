# Usar imagem do OpenJDK para rodar a aplicação
FROM openjdk:17-jdk-slim

# Criar diretório para o app
WORKDIR /app

# Copiar o arquivo JAR gerado pelo Maven
COPY target/backend-0.0.1-SNAPSHOT.jar app.jar

# Expor a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
