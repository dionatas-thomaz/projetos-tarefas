Gerenciamento de Projetos

API REST para gerenciar projetos e tarefas, desenvolvida em Spring Boot.

Tecnologias

Java 17

Spring Boot

Spring Data JPA

H2 Database

Lombok

Como executar

Clone o repositório:

git clone https://github.com/seu-usuario/gerenciamento-projetos.git


Acesse o diretório do projeto:

cd gerenciamento-projetos

em application.properties, informe o seu usuario e senha do seu banco de dados mysql

Execute o projeto pelo sua IDE de preferencia 

url a ser usada no postman ou navagador : http://localhost:8080
http://localhost:8080

Endpoints principais

GET /projetos – lista todos os projetos

POST /projetos – cria um novo projeto

GET /tarefas – lista todas as tarefas
