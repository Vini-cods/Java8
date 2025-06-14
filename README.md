# Sistema de Gerenciamento de Alunos - Spring Boot

## 📚 Descrição

Sistema de cadastro e gerenciamento de alunos desenvolvido com Spring Boot, implementando uma API RESTful completa com operações CRUD (Create, Read, Update, Delete).

## 🛠️ Tecnologias Utilizadas

- **Java 21 or 24**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Web**
- **Jakarta Persistence API (JPA)**
- **Maven** (gerenciamento de dependências)

## 🏗️ Arquitetura do Projeto

O projeto segue o padrão MVC (Model-View-Controller) com arquitetura em camadas:

```
src/main/java/com/escola/senai/
├── Controller/     # Controladores REST
├── Service/        # Regras de negócio
├── Model/          # Entidades JPA
├── Interface/      # Repositórios
└── Java8Application.java  # Classe principal
```

### Camadas da Aplicação

- **Controller**: Responsável por receber requisições HTTP e retornar respostas
- **Service**: Contém a lógica de negócio da aplicação
- **Repository**: Interface para acesso aos dados (JPA Repository)
- **Model**: Entidades que representam as tabelas do banco de dados

## 📋 Funcionalidades

### Endpoints da API

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/alunos` | Lista todos os alunos |
| `POST` | `/alunos` | Cadastra um novo aluno |
| `GET` | `/alunos/{id}` | Busca aluno por ID |
| `PUT` | `/alunos/{id}` | Atualiza dados de um aluno |
| `DELETE` | `/alunos/{id}` | Remove um aluno |

### Modelo de Dados - Aluno

```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@email.com",
  "telefone": "(11) 99999-9999"
}
```

## 🚀 Como Executar

### Pré-requisitos

- Java 8 ou superior
- Maven 3.6+
- IDE de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

### Passos para execução

1. **Clone ou baixe o projeto**

2. **Configure o banco de dados**
   - O projeto usa JPA, configure o `application.properties` com suas credenciais de banco

3. **Execute a aplicação**
   ```bash
   mvn spring-boot:run
   ```
   
   Ou execute a classe `Java8Application.java` diretamente pela IDE

4. **Acesse a API**
   - URL base: `http://localhost:8080`
   - Endpoint principal: `http://localhost:8080/alunos`

## 📝 Exemplos de Uso

### Cadastrar um novo aluno
```bash
POST http://localhost:8080/alunos
Content-Type: application/json

{
  "nome": "Maria Santos",
  "email": "maria.santos@email.com",
  "telefone": "(11) 88888-8888"
}
```

### Listar todos os alunos
```bash
GET http://localhost:8080/alunos
```

### Buscar aluno por ID
```bash
GET http://localhost:8080/alunos/1
```

### Atualizar dados do aluno
```bash
PUT http://localhost:8080/alunos/1
Content-Type: application/json

{
  "nome": "Maria Santos Silva",
  "email": "maria.silva@email.com",
  "telefone": "(11) 77777-7777"
}
```

### Deletar um aluno
```bash
DELETE http://localhost:8080/alunos/1
```

## 🎯 Conceitos Aprendidos

- **Injeção de Dependência** com Spring
- **Anotações Spring**: `@RestController`, `@Service`, `@Entity`, `@Repository`
- **Mapeamento HTTP**: `@GetMapping`, `@PostMapping`, `@PutMapping`, `@DeleteMapping`
- **JPA/Hibernate**: Mapeamento objeto-relacional
- **Arquitetura em camadas**
- **API RESTful** e boas práticas
