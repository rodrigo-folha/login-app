
# Página de Login

Uma estudo de aplicação angular com autenticação e integração com o backend.

## Descrição

Este projeto tem como objetivo criar uma aplicação Angular com autenticação e integração com o backend, para estudo de **CORS** usando **Springboot** e **jwt**, para o frontend foi utilizado **Angular V19**.

## Tecnologias Utilizadas

- **Backend**: Springboot, jwt, JPA
- **Frontend**: Angular V19, TypeScript
- **Banco de Dados**: H2

## Instalação

### Clonando o repositório

Clone o repositório:
   ```sh
   git clone https://github.com/rodrigo-folha/login-app.git
   ```

### Backend (Springboot)

1. Entre no diretório do repositório:

   ```sh
   cd login-app/login-auth-api
   ```

2. Baixe as dependências:

   ```sh
   ./mvnw clean install
   ```

3. Rode a aplicação localmente:

   ```sh
   ./mvnw spring-boot:run
   ```

### Frontend (Angular)

1. Entre no diretório do repositório:

   ```sh
   cd login-app/login-app
   ```

2. Baixe as dependências:

   ```sh
   npm install
   ```

3. Rode a aplicação localmente:

   ```sh
   ng serve
   ```
### Banco de Dados (H2)

1. Configure o banco de dados conforme o arquivo de configuração `application.properties`.