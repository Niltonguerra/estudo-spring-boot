
## pontos relevantes sobre o assunto:
- **Query Methods**: legíveis para consultas simples, mas o nome do método vira ilegível rápido se a lógica crescer (mais de 2-3 condições). Aí o `@Query` compensa.
- **JPQL opera sobre entidades**, não sobre tabelas — por isso `Product p` e `p.price`, não `products` e `price`. Se precisar de SQL nativo puro (funções específicas do banco, performance crítica), existe `@Query(nativeQuery = true)`, mas isso é passo posterior.
- **`@Param`** amarra o nome do parâmetro no JPQL ao parâmetro do método — sem isso o Spring tenta usar posição (`?1`, `?2`), mais frágil a erros de ordem.

