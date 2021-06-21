# Sistema de gerenciamento de pessoas em API REST com Spring Boot
Repositório com a minha versão do projeto final do bootcamp Avanade "Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring" da [DIO](https://digitalinnovation.one/)

-----------------------

O objetivo deste projeto é desenvolver um pequeno sistema para o gerenciamento de pessoas através de uma API REST, utilizando o frameworkcriada com o Spring Boot.



#### Desenvolvimento

Foram desenvolvidas as seguintes tarefas:

* Configurações iniciais de um projeto com o Spring Boot Initialzr
* Criação de modelo de dados para o mapeamento de entidades em bancos de dados
* Desenvolvimento de operações de gerenciamento de pessoas  (Cadastro, leitura, atualização(integral) e remoção de pessoas do sistema) com o padrão arquitetural REST (GET, POST, PUT e DELETE)
* Desenvolvimento de teste unitário para validação da funcionalidade (só para o método createPessoa, verificando a mensagem de retorno)
* Implantação do sistema na nuvem através do Heroku



#### Tecnologias e Dependências utilizadas

- Java 8
- Maven 4.0.0
    - **Lombok**
    - **Map Struct**
    - **H2 Database**
- Spring Boot (2.5.1)
    - **Spring Boot DevTools**
    - **Spring Web**
    - **Spring Data JPA**

    - **Spring Boot Actuator**
- Git/GitHub para versionamento do código
- Heroku para deploy na nuvem