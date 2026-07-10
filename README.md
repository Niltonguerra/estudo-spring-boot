# estudo-spring-boot

comando para criar o projeto:
spring init --dependencies=web,data-jpa,postgresql --build=maven --java-version=21 meu-projeto

comando para criar o banco:
docker run --name meu-postgres -e POSTGRES_PASSWORD=senha123 -e POSTGRES_DB=meudb -p 5432:5432 -d postgres


comando para rodar o projeto:
./mvnw spring-boot:run