## RH_API
-   ---

api para gerenciar funcionarios

### Infos:

- porta: 8081
- db: h2-database
- flyway: migracao de base de dados
- há uma colecao do postaman para auxiliar os testes

### API

| Resource         | Metodo | Descricao             |
|------------------|-------|-----------------------|
|/api/funcionarios | (GET) | Retorna 200 OK        |
|/api/funcionarios|(POST)| Retorna 200 OK|
|/api/funcionarios/{id}|(GET) | Retorna 200 OK|
|/api/funcionarios/atualizar-informacoes|(PUT) | Retorna 200 OK|
|/api/funcionarios/atualizar-informacoes|(PATCH)| Retorna 204 NO_CONTENT|
|/api/funcionarios/remover/{id}|(DELETE)| Retorna 204 NO_CONTENT|

### Iniciar a api

`./mvnw spring-boot:run`

### TODO-LIST:

- [x] consulta api viaCep
- [x] cache
- [ ] logs
- [ ] profiles
- [ ] configuracao por perfil
- [ ] banco especifico para perfis diferentes
- [ ] banco h2 apenas para testes
- [x] migrations
- [x] atualizcao parcial de recurso (PathMethod)
- [ ] Dockerfile
- [ ] Testes unitários
- [ ] Testes de Integracão
- [x] colecao de testes (postman)
- [x] exceptions customizadas
- [x] mapstruct
- [ ] grpc
- [ ] implementar clean architecture ou hexagonal
- [ ] deploy em alguma cloud
- [ ] configurar pipe para deploy com integracao ao git
