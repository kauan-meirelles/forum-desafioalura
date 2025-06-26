# 🚀 Forum Desafio Alura

Este projeto é uma API REST desenvolvida com Java e Spring Boot, simulando a funcionalidade de um fórum. Foi criado como parte do desafio da Alura. 🎯

## ✨ Funcionalidades

- 📝 **CRUD completo de tópicos:**
  - ➕ Criar novo tópico
  - 📋 Listar todos os tópicos
  - 🔍 Visualizar tópico por ID
  - ✏️ Atualizar tópico existente
  - 🗑️ Excluir tópico
- 🔐 **(Opcional)** Autenticação e autorização com Spring Security + JWT

## 🛠️ Tecnologias

- ☕ Java 17
- 🌱 Spring Boot
- 🌐 Spring Web MVC (REST)
- 🗄️ Spring Data JPA + Hibernate
- 🐬 MySQL (ou outro banco relacional)
- 🔒 Spring Security + JWT (se implementado)
- 📦 Maven como gerenciador de dependências

## ⚙️ Pré-requisitos

- ☕ Java JDK 17+
- 📦 Maven 3.6+
- 🐬 Banco de dados MySQL (ou equivalente)

## 🚀 Guia de instalação e execução

1. Clone o repositório:
   ```bash
   git clone https://github.com/kauan-meirelles/forum-desafioalura.git
2. Navegue até o diretório do projeto:
  ```bash
   cd forum-desafioalura
  ```   
3. Compile e execute o projeto:
  ```bash
  mvn spring-boot:run
  ```
4. Acesse a API em http://localhost:8080. 🌐

## 📌 Endpoints disponíveis
GET /api/topicos — Listar todos os tópicos 📋

GET /api/topicos/{id} — Visualizar tópico por ID 🔍

POST /api/topicos — Criar novo tópico ➕

PUT /api/topicos/{id} — Atualizar tópico existente ✏️

DELETE /api/topicos/{id} — Excluir tópico 🗑️

## 🔐 Autenticação e autorização (opcional)
Se implementado, a autenticação é realizada via JWT. Para obter um token, faça uma requisição POST para o endpoint /api/auth/login com as credenciais do usuário. 🔑

## 🤝 Contribuições
Contribuições são bem-vindas! Sinta-se à vontade para abrir issues ou pull requests. 🚧

## 📄 Licença
Este projeto está licenciado sob a MIT License. 📜
   
   

