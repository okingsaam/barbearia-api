# 💈 Barbearia API

API REST completa para gerenciamento de barbearia, desenvolvida com **Spring Boot** e **PostgreSQL**.
Autenticação segura com **Spring Security + JWT**.

---

## 🌐 API em Produção

> API deployada e funcionando no Railway:

**Base URL:** `https://diligent-transformation-production-4c42.up.railway.app`

**Swagger:** `https://diligent-transformation-production-4c42.up.railway.app/swagger-ui/index.html`

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 4
- Spring Security + JWT (jjwt 0.12.6)
- Spring Data JPA / Hibernate
- PostgreSQL
- Maven
- Swagger / OpenAPI
- Lombok

---

## 🔐 Autenticação

A API utiliza autenticação via **JWT (JSON Web Token)**.

### Registrar usuário
```
POST /auth/register
Content-Type: application/json

{
  "email": "usuario@email.com",
  "senha": "suasenha"
}
```

### Login
```
POST /auth/login
Content-Type: application/json

{
  "email": "usuario@email.com",
  "senha": "suasenha"
}
```

Resposta:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

### Usando o token

Em todas as requisições protegidas, envie o header:
```
Authorization: Bearer <seu_token>
```

Rotas públicas: `/auth/**`, `/swagger-ui/**`, `/v3/api-docs/**`

---

## 📦 Estrutura do Projeto

```
src/main/java/com/barbearia/barbearia_api
├── controller
├── infrastructure
│   ├── entity
│   └── repository
├── security
│   ├── dto
│   ├── AuthService
│   ├── AuthController (dentro de controller/)
│   ├── JwtFilter
│   ├── JwtService
│   └── SecurityConfig
└── service
```

Arquitetura:
```
Controller → Service → Repository → Database
```

---

## ⚙️ Funcionalidades

### 👤 Clientes
- Cadastrar, listar, buscar por ID e deletar

### ✂️ Barbeiros
- Cadastrar e listar

### 🧾 Serviços
- Cadastrar e listar

### 🛍 Produtos
- Cadastrar e controle de estoque

### 📅 Agendamentos
- Agendar com relacionamento entre cliente, barbeiro e serviço

### 💰 Vendas
- Registro de vendas com múltiplos itens vinculados a produtos

---

## 🗄 Banco de Dados

Banco: **PostgreSQL**

Tabelas principais:
```
usuarios
clientes
barbeiros
servicos
produtos
agendamentos
vendas
itens_venda
```

Relacionamentos:
```
Agendamento → Cliente, Barbeiro, Servico
Venda → ItemVenda → Produto
```

---

## ▶️ Como executar localmente

### 1. Clonar o repositório
```bash
git clone https://github.com/okingsaam/barbearia-api.git
cd barbearia-api
```

### 2. Configurar variáveis de ambiente
```properties
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/barbearia
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=suasenha
```

### 3. Rodar a aplicação
```bash
mvn spring-boot:run
```

---

## 📚 Documentação Swagger

```
http://localhost:8080/swagger-ui/index.html
```

---

## 📌 Endpoints principais

### Auth (público)
```
POST /auth/register
POST /auth/login
```

### Clientes (requer token)
```
POST   /clientes
GET    /clientes
GET    /clientes/{id}
DELETE /clientes/{id}
```

### Barbeiros
```
POST /barbeiros
GET  /barbeiros
```

### Serviços
```
POST /servicos
GET  /servicos
```

### Produtos
```
POST /produtos
GET  /produtos
```

### Agendamentos
```
POST /agendamentos
GET  /agendamentos
```

### Vendas
```
POST /vendas
GET  /vendas
```

---

## 👨‍💻 Autor

**Sam Douglas Francisco dos Santos**
Estudante de Análise e Desenvolvimento de Sistemas

- GitHub: https://github.com/okingsaam
- LinkedIn: https://www.linkedin.com/in/samdouglas-dev/
