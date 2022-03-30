# Sistema de Barbearia / Back-End

## Resumo
Projeto utilizando boas práticas de Engenharia de Software tais como desenvolvimento em camadas (DDD) e tratamento de exceções.
API Rest usando Java com Spring Boot e banco de dados MySQL. JPA com Hibernate para mapeamento objeto-relacional.

## Tecnologias e Frameworks
* Java
* Spring Boot

## Estrutura de camadas 
![alt text](https://s3-sa-east-1.amazonaws.com/biazin-curso-spring-ionic/padrao-camadas-ddd.png)

    \----projeto
       \---barbearia
        │-----BarbeariaApplication.java
        │
        ├-----config
        │       DevConfig.java
        │       TestConfig.java
        │
        |---domain
        │   │---Agendamento.java
        │   │---Barbeiro.java
        │   │---Cliente.java
        │   │---Pessoa.java
        │   │
        │   └---DTO
        │        |----AgendamentoDTO.java
        │        |----BarbeiroDTO.java
        │        |----ClienteDTO.java
        │
        ├----enums
        │     |----Perfil.java
        │     |----Status.java
        │
        ├----repositories
        │      |----AgendamentoRepository.java
        │      |----BarbeiroRepository.java
        │      |----ClienteRepository.java
        │      |----PessoaRepository.java
        │
        ├----resources
        │      │----AgendamentoResouce.java
        │      │----BarbeiroResource.java
        │      │----ClienteResource.java
        │      │
        │      └----exceptions
        │              |-----FieldMessage.java
        │              |-----ResourceExceptionHandle.java
        │              |-----StandardError.java
        │              |-----ValidationError.java
        │
        └---services
              │----AgendamentoService.java
              │----BarbeiroService.java
              │----ClienteService.java
              │----DBService.java
              │
              └----exceptions
                      |----DataIntegrityViolationException.java
                      |----ObjectnotFoundException.java
                      
                      
                      
## Autor

* **[Heleno Souza](https://github.com/helenosouza)**
* **[Mardoqueu Sousa](https://github.com/mardoqueusousa)**
