# CRUD DAO JDBC

Projeto de exemplo em Java para manipulação de dados em banco relacional utilizando JDBC. Baseado em um curso da Udemy, com modificações e melhorias próprias.

## Tecnologias

- Java
- JDBC
- MariaDB (ou MySQL)
- IDE: IntelliJ IDEA
- Gerenciamento de dependências: libs JDBC adicionadas manualmente

## Estrutura do Projeto

- **model**: classes de entidade (Seller, Department)  
- **model.dao**: interfaces DAO  
- **model.dao.impl**: implementação JDBC dos DAOs  
- **db**: classe de conexão com banco e exceções personalizadas  
- **db.application**: classes de teste `Program` e `Program2`  

## Banco de Dados

O script `database.sql` cria as tabelas e insere dados iniciais:

- Tabela `department` (Id, Name)  
- Tabela `seller` (Id, Name, Email, BirthDate, BaseSalary, DepartmentId)  

> ⚠️ Execute os comandos **uma tabela/insert por vez** caso utilize o script diretamente no seu SGBD.

## Funcionalidades

- Inserir, atualizar, deletar e buscar `Seller`  
- Inserir, atualizar, deletar e buscar `Department`  
- Buscar `Seller` por departamento  
- Tratamento de exceções com `DbException` e `DbIntegrityException`  

## Como Rodar

1. Configure o arquivo `db.properties` com usuário, senha e URL do banco:

```properties
db.user=seu_usuario
db.password=sua_senha
db.url=jdbc:mariadb://localhost:3306/coursejdbc
