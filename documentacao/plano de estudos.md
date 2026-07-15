### Fundamentos

- [ ]  IoC/DI: `@Component`, `@Service`, `@Repository`, `@Configuration`
- [ ]  Injeção via construtor (não usar `@Autowired` em campo)
- [ ]  Autoconfiguration e `@SpringBootApplication`
- [ ]  Profiles e `application.yml`/`.properties`
- [ ]  Escopos de bean (singleton, prototype)
- [ ]  Build de uma API REST CRUD simples

### Persistência

- [ ]  Spring Data JPA: repositórios, Query Methods, `@Query`/JPQL
- [ ]  Hibernate: lazy vs eager, resolver N+1
- [ ]  Flyway ou Liquibase (migrations)
- [ ]  `@Transactional`: propagação e isolamento
- [ ]  Decisão de projeto: DTO vs expor entidade JPA

### Camada web

- [ ]  `@RestController`, `@RequestBody`, `@PathVariable`, `@RequestParam`
- [ ]  Bean Validation (`@Valid`, `@NotNull`, validador customizado)
- [ ]  `@ControllerAdvice` + `@ExceptionHandler` (tratamento centralizado de erro)
- [ ]  Versionamento de API (path vs header)

### Segurança

- [ ]  Spring Security: `SecurityFilterChain`, filtros
- [ ]  JWT aplicado com Spring
- [ ]  OAuth2/OIDC básico
- [ ]  CORS e CSRF (quando desabilitar)

### Testes

- [ ]  JUnit 5 + Mockito
- [ ]  `@SpringBootTest`, `@WebMvcTest`, `@DataJpaTest`
- [ ]  Testcontainers (integração com banco real)

### Arquitetura e distribuído (aplicando o que já sabe)

- [ ]  Estruturar projeto em Hexagonal/Clean Architecture com Spring, mantendo domínio livre de anotações do framework
- [ ]  Spring Cloud: Config Server, Service Discovery (Eureka), Gateway
- [ ]  Spring Kafka ou RabbitMQ + padrão Saga
- [ ]  Resilience4j (Circuit Breaker — substituto do Hystrix, deprecado)

### Projeto finalizado

- [ ]  2+ serviços se comunicando
- [ ]  Persistência + migrations
- [ ]  Segurança JWT
- [ ]  Testes com Testcontainers
- [ ]  Deploy em Kubernetes