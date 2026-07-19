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
permite criar configurações de ambiente personalizadas para cada ambiente
para isso você deve apagar o ``application.properties`` e criar um application.yml e para personalizar por ambiente é só criar um novo arquivo no formato `application-{AMBIENTE}.yml`

| Arquivo                         | Papel                                        |
| ------------------------------- | -------------------------------------------- |
| `application.yml`               | Config comum + qual perfil ativar por padrão |
| `application-dev.yml`           | Sobrescreve/adiciona config só pra dev       |
| `application-prod.yml`          | Sobrescreve/adiciona config só pra prod      |
| `--spring.profiles.active=prod` | Ativa um perfil na hora de rodar             |
| `@Profile("dev")`               | Ativa beans inteiros condicionalmente        |

## Diferenças entre `@RequestBody`, `@PathVariable`, `@RequestParam`

|Anotação|De onde extrai o valor|Exemplo na URL/requisição|
|---|---|---|
|`@PathVariable`|Do **caminho** da URL|`/tasks/5` → pega o `5`|
|`@RequestParam`|Da **query string**|`/tasks?done=true` → pega o `true`|
|`@RequestBody`|Do **corpo (body)** da requisição|JSON enviado no POST/PUT|


## funções de alguns decorator do spring
- @RestControllerAdvice
	- usado para tranformar uma classe em um handler geral para tratar erros gerais da aplicação.
	- ele une dois outros decorator'
		- **`@ControllerAdvice`****
			- fala que vai ser um handler de tratamento de erros para todos os controller
		- ``@ResponseBody``
			- garante que o retorno vai no formato JSON e não em um formato HTML ou outro.


dasdasdasdasd
sssss