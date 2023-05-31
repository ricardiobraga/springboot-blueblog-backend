# The Blue Blog CRUD Backend
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/ricardiobraga/springboot-blueblog-backend/blob/main/LICENSE.md) 

# SOBRE

[https://blueblog-frontend.vercel.app/](https://blueblog-frontend.vercel.app/)

Esse projeto inicialmente foi feito para teste de uma vaga de frontend. A partir de um layout feito no Figma e uma API que foram fornecidos pela empresa eu desenvolvi esta aplicação.
Como tenho focado meus estudos em Java e Springboot desde o começo de 2023, decidi aproveitar esse frontend e recriar o backend semelhante ao fornecido pela empresa.


# TECHNOLOGIES
- JAVA 17
- Spring boot 3.10
- Postgres
- JPA HIBERNATE

# INSTALAÇÃO
## 1 - clone a aplicação
```
git@github.com:ricardiobraga/springboot-blueblog-backend.git

```
## 2 - Alteracao do profile ativo para "test"
```
spring.profiles.active=test
```
## 3 - Criar um DB no Postgres e alterar as configurações no arquivo application.properties
```
spring.datasource.username=postgres
spring.datasource.password=1234567
spring.datasource.url=jdbc:postgresql://localhost:5432/blog
```


# API ROUTES
```
GET /api//api/posts

POST /api//api/posts

PATCH /api/posts/{postId}

DELETE /api/posts/{postId}

```