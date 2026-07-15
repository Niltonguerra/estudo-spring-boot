## @RestController, @Service, @Repository vs @Configuration
- tipo decorators do nestJS para controller,service
	- `@RestController`, `@Service`, `@Repository`

- tipo providers do nestJS
	- instancia dependências externas
	- `@Configuration`



## @SpringBootApplication
é 3 coisa em uma coisa, sendo as 3:
1. @Configuration
usado para injetar dependências externas no projeto
2. @EnableAutoConfiguration
permite configurar tudo que fizer sentido nas dependências 
3. @ComponentScan
faz um escaneamento geral do projeto para mapear todos os @components(@RestController, @Service, @Repository e etc)


## Perfis separados (`dev`, `prod`) 
permite criar configurações de a

|Arquivo|Papel|
|---|---|
|`application.yml`|Config comum + qual perfil ativar por padrão|
|`application-dev.yml`|Sobrescreve/adiciona config só pra dev|
|`application-prod.yml`|Sobrescreve/adiciona config só pra prod|
|`--spring.profiles.active=prod`|Ativa um perfil na hora de rodar|
|`@Profile("dev")`|Ativa beans inteiros condicionalmente|