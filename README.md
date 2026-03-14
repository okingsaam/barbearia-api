# 💈 Barbearia API

API REST para gerenciamento de uma barbearia, desenvolvida com **Spring Boot** e **PostgreSQL**.
O sistema permite gerenciar clientes, barbeiros, serviços, produtos, vendas e agendamentos.

---

# 🚀 Tecnologias utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Swagger / OpenAPI

---

# 📦 Estrutura do Projeto

```
src/main/java/com/barbearia/barbearia_api

controller
│
infrastructure
│   ├── entity
│   │   Cliente
│   │   Barbeiro
│   │   Servico
│   │   Produto
│   │   Venda
│   │   ItemVenda
│   │   Agendamento
│   │
│   └── repository
│
service
│
BarbeariaApiApplication
```

Arquitetura utilizada:

```
Controller → Service → Repository → Database
```

---

# ⚙️ Funcionalidades

### 👤 Clientes

* Cadastrar cliente
* Listar clientes
* Buscar cliente por ID
* Deletar cliente

### ✂️ Barbeiros

* Cadastro de barbeiros
* Listagem de barbeiros

### 🧾 Serviços

* Cadastro de serviços da barbearia
* Listagem de serviços

### 🛍 Produtos

* Cadastro de produtos
* Controle de estoque

### 📅 Agendamentos

* Agendar atendimento
* Relacionamento entre cliente, barbeiro e serviço

### 💰 Vendas

* Registro de vendas
* Vários itens por venda
* Produtos vinculados

---

# 🗄 Banco de Dados

Banco utilizado:

PostgreSQL

Principais tabelas:

```
clientes
barbeiros
servicos
produtos
agendamentos
vendas
itens_venda
```

Relacionamentos principais:

```
Agendamento → Cliente
Agendamento → Barbeiro
Agendamento → Servico

Venda → ItemVenda
ItemVenda → Produto
```

---

# ▶️ Como executar o projeto

### 1️⃣ Clonar repositório

```
git clone https://github.com/seu-usuario/barbearia-api.git
```

### 2️⃣ Entrar na pasta

```
cd barbearia-api
```

### 3️⃣ Configurar banco de dados

No arquivo:

```
application.properties
```

Configurar:

```
spring.datasource.url=jdbc:postgresql://localhost:2714/barbearia_db
spring.datasource.username=postgres
spring.datasource.password=123
```

---

### 4️⃣ Rodar aplicação

```
mvn spring-boot:run
```

ou rodar a classe:

```
BarbeariaApiApplication
```

---

# 📚 Documentação da API

Após rodar o projeto, acesse:

```
http://localhost:8080/swagger-ui/index.html
```

Interface para testar todos os endpoints da API.

---

# 📌 Endpoints principais

Clientes

```
POST /clientes
GET /clientes
GET /clientes/{id}
DELETE /clientes/{id}
```

Barbeiros

```
POST /barbeiros
GET /barbeiros
```

Serviços

```
POST /servicos
GET /servicos
```

Produtos

```
POST /produtos
GET /produtos
```

Agendamentos

```
POST /agendamentos
GET /agendamentos
```

Vendas

```
POST /vendas
GET /vendas
```

---

# 🎯 Objetivo do projeto

Este projeto foi desenvolvido como prática de backend para consolidar conhecimentos em:

* APIs REST
* Spring Boot
* JPA / Hibernate
* modelagem de banco de dados
* arquitetura em camadas

---

# 👨‍💻 Autor

Douglas
Estudante de Análise e Desenvolvimento de Sistemas

Projeto desenvolvido para fins de estudo e portfólio.
