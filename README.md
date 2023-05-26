# Desafio-Viceri

## Objetivo

O objetivo do projeto é criar uma API para cadastro, alteração, exclusão e listagem de tarefas.

---

## README do Projeto

### Ambiente local

- Intellij Community Edition 2023.1.2
- Java JDK 11
- PostgreSQL 15.3 com pgAdmin 4
    - Script para criação do banco e tabelas: [bizu.sql](\bizu.sql)
- Swagger v2 - http://localhost:8080/swagger-ui.html *Link padrão. Pode ter alteração da porta caso a 8080 ja esteja em uso*

---

### Minha aplicação

Inicialmente pretendia utilizar a JDK 17 junto ao Spring Boot 3.0, por serem mais atuais. Porém tive alguns problemas na codificação e compilação e preferi regredir para a JDK 11 e Spring 2.5.1.

O mesmo se deu a SQL, onde iria utilizar o SQl, mas devido a algumas falhas de conexão, preferi utilizar o PostgreSQL.
Ambas as alterações foram devida economia de tempo.

Em minha aplicação, utilizei a abordagem de Microsserviços e boas praticas do Clean Code, para facilitar na manutenção do codigo, apresentando uma API mais definida.
Utilizei das seguintes bibliotecas, como principais;
- Spring Web: Realizar o build da API REST em modo web, mantendo-se ativa usando Spring MVC.
- Lombok: para auxiliar na construção dos objetos e metodos através das Annotations.
- Spring Data JPA e PostgreSQL Driver: para a conexão e comunicação com bando de dados.

Na controller de Usuarios([UserControler](\todo\src\main\java\br\com\desafio\todo\controller\UserController.java)) foi implementado apenas o cadastro de um usuario novo, passando a senha pelo PasswordEncoder. Também tendo o metodo para validar se a senha confere, uma vez que salvando a senha encripitada,
não é possivel fazer uma comparação direta. <br/>
No cadastro de Usuario, o **id** automatico foi implementado através do **IDENTITY** no banco de dados.

Na controle de Tarefas([ToDoController](\todo\src\main\java\br\com\desafio\todo\controller\ToDoController.java)) foram implementados todos os metodos solicitados, cadastro, alteração, conclusão e listagem. </br>
Nas tarefas, o **id** automatico foi implementado através do **SEQUENCE** do banco de dados. Fiz essa diferença do IDENTITY usado em usuarios, pois com o SEQUENCE, em demandas futuras, é possivel explorar mais a parte de cadastro, como um cadastro de diversas tarefas, ja tendo retornadas os seus codigos de tarefa, por exemplo. </br>
O delete fiz de maneira simples, para demonstração, mas acredito que o ideal seria uma alteração, inativando/cancelando a tarefa, para manter historicos futuros. </br>
Trabalhei com os campos **priority** e **status** com modelos **ENUM**, afim de facilitar a inclusão dos dados, onde o front passaria apenas informações padrão do ENUM e também receberia as informações corretas, assim deixando a responsabilidade mais para a API.

Em ambas situações, trabalhei com **SERVICES**, para tratar toda a logistica dos metodos, **REPOSITORIES**, para tratar as comunicações com banco de dados através da JPA e com **RESPONSES, REQUESTS e MAPPERS**, permitindo que as respostas e requisões para a API sejam padrões e informações desnecessarias ao front, não fiquem tão abertas, bem como o mapeamento de informações entre elas e os objetos principais da API.

Por fim, só não consegui implementar as autenticações via JWT, pois enquanto estava realizando as configurações, todo o resto da API estava sendo comprometida, gerando erros e mal funcionamento. </br> 
Ja utilizei autenticação JWT anteriomente, mas esta foi a primeira vez tentando implementar e configurar, o acabou me tomando mais tempo do que o esperado.