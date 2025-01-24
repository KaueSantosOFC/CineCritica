# CineCrítica
> Um sistema para gerenciar filmes assistidos e suas avaliações.

CineCrítica é uma aplicação web desenvolvida em Java com Spring Boot. O sistema permite adicionar, visualizar, avaliar e excluir filmes assistidos atráves de uma api externa. A interface foi construída com Thymeleaf e é totalmente responsiva para dispositivos móveis.

---

## 🌐 Projeto Online

Você pode acessar o CineCrítica funcionando diretamente pelo link público do Railway:

🔗 **[CineCrítica - Online no Railway](https://cinecritica-production.up.railway.app)**

---

## 🛠️ Tecnologias Usadas

O projeto foi desenvolvido com as seguintes tecnologias:

### Backend
- **Java 17**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java.
  - **Spring Data JPA**: Gerenciamento de persistência de dados.
  - **Spring Web**: Criação de APIs REST.
  - **H2 Database**: Banco de dados em memória para testes e desenvolvimento.
  - **Springdoc OpenAPI**: Integração com Swagger para documentação automática da API.
  - **OpenFeign**: Cliente HTTP declarativo para chamadas a APIs externas.
- **Hibernate**: ORM (Object Relational Mapping) para gerenciar entidades e tabelas.

### Frontend
- **Thymeleaf**: Motor de templates usado para renderizar páginas HTML no servidor.
- **HTML5, CSS3 e JavaScript**: Estrutura, estilo e interatividade da interface.
- **Responsividade**: Interface adaptada para dispositivos móveis.

### Deploy
- **Railway**: Plataforma de deploy para hospedar a aplicação e banco de dados.

---

## 🚀 Instalando e Configurando o Projeto

### Pré-requisitos

Certifique-se de ter instalado:
- Java 17 ou superior.
- Maven.
- PostgreSQL.
- Git.
- Conta na TMDB para API.

### Clonando o repositório

Para começar, clone o projeto para sua máquina local:

```bash
git clone https://github.com/seu-usuario/cinecritica.git
cd cinecritica
```

### Configurando as dependências

Use o Maven para baixar as dependências e compilar o projeto:

```bash
mvn clean install
```

Isso irá preparar o projeto para execução.

---

## 🗄️ Configurando o Banco de Dados

1. **Crie um banco de dados no PostgreSQL**:
   ```sql
   CREATE DATABASE cinecritica;
   ```

2. **Configure as variáveis de ambiente** (recomendado para segurança):
   - `DB_URL`: URL do banco de dados no formato `jdbc:postgresql://<host>:<porta>/<nome_do_banco>`.
   - `DB_USERNAME`: Usuário do banco de dados.
   - `DB_PASSWORD`: Senha do banco de dados.

3. **Exemplo de configuração no arquivo `application.yml`**:
   ```yaml
   spring:
     tmdb:
       api-key: ${TMDB_API_KEY}
     datasource:
       url: ${DB_URL}
       username: ${DB_USERNAME}
       password: ${DB_PASSWORD}
     jpa:
       hibernate:
         ddl-auto: update
       properties:
         hibernate:
           dialect: org.hibernate.dialect.PostgreSQLDialect
   ```
- A ```${TMDB_API_KEY}``` será fornecida ao criar uma conta no 🔗 **[TMDB](https://www.themoviedb.org).**
---

## ▶️ Executando o Projeto

Após configurar o banco de dados, execute o projeto com:

```bash
mvn spring-boot:run
```

O servidor estará disponível em [http://localhost:8080](http://localhost:8080).

---

## 🌐 OpenFeign
O OpenFeign foi configurado para realizar chamadas a APIs externas, como a API do TMDb para obter informações de filmes.

- O cliente Feign está configurado no pacote ```com.cinecritica.clients```.
- Para configurar a API Key e outros parâmetros, use as variáveis de ambiente no arquivo ```application.yml```.

---

## 📖 Swagger (Springdoc OpenAPI)
A documentação da API está disponível via Swagger:

- URL: [Railway/swagger](https://cinecritica-production.up.railway.app/swagger-ui/index.html)

---

## 🌐 Deploy no Railway

Para fazer o deploy no Railway, siga os passos abaixo:

1. Faça login na [Railway](https://railway.app/).
2. Crie um novo projeto e conecte-o ao repositório do GitHub.
3. Configure as variáveis de ambiente:
   - `DB_URL`: URL do banco de dados fornecida pelo Railway.
   - `DB_USERNAME`: Usuário fornecido pelo Railway.
   - `DB_PASSWORD`: Senha fornecida pelo Railway.
4. O Railway cuidará automaticamente do build e do deploy.
5. Após o deploy, você receberá uma URL para acessar a aplicação.

---

## 🎯 Funcionalidades

- **Adicionar Filmes**: Cadastre filmes assistidos com título e descrição.
- **Avaliar Filmes**: Adicione notas personalizadas aos filmes.
- **Excluir Filmes**: Remova filmes que você não deseja mais visualizar.
- **Documentação Automática**: Swagger para explorar as APIs.
- **Interface Responsiva**: Compatível com dispositivos móveis e desktops.

---

## 📁 Estrutura do Projeto

O CineCrítica utiliza a arquitetura **MVC (Model-View-Controller)**:

- **Model**: Define as classes que representam os dados, como `Movie`.
- **View**: Templates Thymeleaf que renderizam o front-end.
- **Controller**: Gerencia as rotas HTTP e conecta os serviços aos modelos.

---

## 🛠️ Desenvolvendo

Para contribuir no desenvolvimento, siga estas etapas para configurar o ambiente:

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/cinecritica.git
   cd cinecritica
   ```

2. Instale as dependências:
   ```bash
   mvn clean install
   ```

3. Inicie o projeto:
   ```bash
   mvn spring-boot:run
   ```

Agora você pode realizar alterações no projeto.

---

## 📤 Contribuindo

Contribuições são bem-vindas! Siga os passos abaixo para contribuir:

1. Faça um fork do projeto.
2. Crie uma branch para sua funcionalidade:
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```

3. Faça as alterações necessárias.
4. Commit suas alterações:
   ```bash
   git commit -m "Adiciona nova funcionalidade"
   ```

5. Faça o push para sua branch:
   ```bash
   git push origin feature/nova-funcionalidade
   ```

6. Abra um Pull Request no repositório principal.

---

## 📚 Links

- **Projeto no GitHub**: [CineCrítica](https://github.com/KaueSantosOFC/CineCritica)
- **Railway**: [https://railway.app/](https://railway.app/)
- **Thymeleaf**: [Documentação oficial](https://www.thymeleaf.org/documentation.html)
- **The Movie Database (TMDB)**:[Documentação oficial](https://developer.themoviedb.org/docs/getting-started)

---

## 📝 Licença

O projeto está licenciado sob a [MIT License](LICENSE). Você pode usá-lo e modificá-lo livremente.

---

Se tiver dúvidas ou problemas, abra uma issue no repositório!
