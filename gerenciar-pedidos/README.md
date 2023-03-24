# Java-Order-Management-API


## Tecnologias usadas
- Java 8 SpringBoot
- Docker-Compose
- Unity test Junit4
- Maven
- MySQL
- log4j
- GIT
- Hibernate


## Teste

Executar no terminal do docker-Compose
```sh
docker-compose up -d  
```
Para testar sua aplicação Spring Boot, você pode usar a ferramenta Postman ou outra ferramenta similar para enviar requisições HTTP aos endpoints da sua API. Siga os passos abaixo:

Inicie a aplicação Spring Boot:

No seu IDE, execute a classe principal que contém o método main (geralmente, a classe que possui a anotação @SpringBootApplication).
Ou, se você já gerou o arquivo JAR da aplicação, execute o comando java -jar nome_do_arquivo.jar no terminal.
Abra o Postman ou outra ferramenta de teste de API.

Configure e envie as requisições HTTP para testar os diferentes endpoints da sua aplicação. Por exemplo:

Para testar o cadastro de Item:

- Método: POST
> URL: http://localhost:8080/api/items
> Headers: Content-Type: application/json

>Body:
```sh
{    
    "nome": "Item"
}
```
Para buscar por id

- Método: GET
>URL: http://localhost:8080/api/items/1
>>Para testar a busca do item pelo id

Para buscar todos
- Método: GET
>URL: http://localhost:8080/api/items
>>Para testar a busca de todos item