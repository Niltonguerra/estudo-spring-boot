
## pontos relevantes sobre o assunto:
- **Query Methods**: legíveis para consultas simples, mas o nome do método vira ilegível rápido se a lógica crescer (mais de 2-3 condições). Aí o `@Query` compensa.
- **JPQL opera sobre entidades**, não sobre tabelas — por isso `Product p` e `p.price`, não `products` e `price`. Se precisar de SQL nativo puro (funções específicas do banco, performance crítica), existe `@Query(nativeQuery = true)`, mas isso é passo posterior.
- **`@Param`** amarra o nome do parâmetro no JPQL ao parâmetro do método — sem isso o Spring tenta usar posição (`?1`, `?2`), mais frágil a erros de ordem.


> [!relevante]
> ⚠️ Nunca edite um arquivo de migration já executado — o Flyway guarda um checksum de cada um na tabela `flyway_schema_history` e vai rejeitar se detectar alteração. Para mudanças, sempre crie um arquivo novo.


## o que é N+1 e como evitar:
- o que é:
	- **N+1** é quando o JPA faz **1 query** para buscar uma lista, e depois **N queries** adicionais para buscar os relacionamentos de cada item.
	- por exemplo: busque todos os autores e todos os livros ligados a eles, o sistema vai fazer o seguinte:
		- busca os autores e pega suas informações incluindo o id de cada um e depois
		- faz uma busca no banco de dados para cada id na tabela de livros, isso faz com que sejam feitas multiplas requisições
```sql
SELECT * FROM author                        -- 1
SELECT * FROM books WHERE author_id = 1     -- 2
SELECT * FROM books WHERE author_id = 2     -- 3
SELECT * FROM books WHERE author_id = 3     -- 4
-- ... até o 10
```

- isso acontece por conta do FetchType.Lazy do JPA, para resolver tem que criar um metodo personalizado no repository,ex:
```java
  // com filtro e ordenação — difícil de fazer com @EntityGraph
@Query("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books WHERE a.active = true ORDER BY a.name")
List<Author> findActiveAuthorsWithBooks();
```
ou 
```java
@EntityGraph(attributePaths = {"books"}) List<Author> findAllWithBooks();
```
usando dessa forma vai ser só uma query, a saber:
```sql
SELECT a.*, b.*
FROM author a
LEFT JOIN books b ON b.author_id = a.id  -- tudo em uma query só
```


isso pode acontecer com qualquer linguagem.


