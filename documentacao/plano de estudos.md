
### 1. API REST CRUD básica

- [ ] Crie uma API REST simples (ex: cadastro de produtos) usando:
- `@RestController`, `@Service`, `@Repository`, `@Configuration` com injeção via construtor✔️
- `@SpringBootApplication` e autoconfiguration padrão✔️
- Perfis separados (`dev`, `prod`) via `application.yml`✔️
- Endpoints com `@RequestBody`, `@PathVariable`, `@RequestParam`✔️
- Validação com `@Valid` + um validador customizado
- Tratamento de erro centralizado com `@ControllerAdvice`

### 2. Persistência de verdade

- [ ] Troque o CRUD acima (ou crie um novo) para usar banco real:

- Spring Data JPA com Query Methods e uma consulta `@Query`/JPQL
- Migrations com Flyway (versionadas, sem `ddl-auto: update`)
- Resolver um N+1 real (force o problema, depois corrija com fetch join ou `@EntityGraph`)
- Definir DTOs de entrada/saída, nunca expor a entidade JPA
- Usar `@Transactional` em um fluxo que precise de propagação (ex: criar pedido + baixar estoque)

### 3. Autenticação e autorização

- [ ] Adicione segurança na API:

- `SecurityFilterChain` com rotas públicas e protegidas
- Login com JWT (gerar, validar, extrair claims)
- Configurar CORS corretamente e decidir (e justificar) se desabilita CSRF

### 4. Suíte de testes

- [ ] Cubra o projeto com testes:

- Unitários com JUnit 5 + Mockito (mockando repository/service)
- `@WebMvcTest` pro controller, `@DataJpaTest` pro repository
- `@SpringBootTest` de integração
- Testcontainers subindo um Postgres real no teste

### 5. Reestruturar em Hexagonal/Clean

- [ ] Pegue o projeto e refatore:

- Separar domínio (sem anotação de framework nenhuma) de infraestrutura
- Portas e adaptadores explícitos (ex: `ProductRepository` como porta, `ProductJpaAdapter` como adaptador)

### 6. Sistema distribuído com 2 serviços

- [ ] Construa um segundo serviço que conversa com o primeiro:

- Comunicação assíncrona via Kafka ou RabbitMQ
- Implementar uma Saga simples (ex: pedido → pagamento → estoque, com compensação)
- Circuit Breaker com Resilience4j em uma chamada entre serviços
- Config Server + Eureka (ou Gateway) coordenando os dois

### 7. Projeto final publicado

- [ ] Empacote os dois serviços do item 6:

- Deploy dos dois em Kubernetes (manifests ou Helm)
- Persistência com migrations, segurança JWT e testes com Testcontainers já embutidos
- Repositório público no GitHub documentando a arquitetura