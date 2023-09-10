# Desafio Place TI
> Resolução do desafio proposto: "Desenvolver um webservice em Java
com Spring que faça as 4 operações básicas: GET, PUT, POST e DELETE".

# Documentação do Projeto

## Pré-requisitos

- Git instalado
- Docker e Docker Compose instalados

## Instruções de Instalação e Execução

### Passo 1: Clonar o Repositório

Para clonar o repositório, abra o terminal e execute o seguinte comando:

```bash
git clone https://github.com/edudu4/desafio-placeti
```


### Passo 2: Navegar até o Diretório do Projeto

Após o clone, navegue até o diretório do projeto usando o comando:

```bash
cd desafio-placeti
```

### Passo 3: Executar o Docker Compose

Para iniciar todos os serviços definidos no arquivo `docker-compose.yml`, execute o seguinte comando:

```bash
docker-compose up
```

Isso iniciará todos os serviços definidos no arquivo `docker-compose.yml`, incluindo a API e o banco de dados.

***
## Documentação da API
--
## Endpoint Marcas


### Criar Marca

**URL**: `/marcas`

**Método**: `POST`

**Corpo da Requisição**:

```json
{
  "nome": "Honda",
  "codigoDenatran": "1234567895432654321",
  "ativo": true
}
```

**Resposta de Sucesso**:

- **Código**: 201

- **Conteúdo**:
```json
{
  "id": 1,
  "codigoDenatran": "1234567895432654321",
  "nome": "Honda",
  "ativo": true,
  "modelos": null
}
```
### Criar Várias Marcas

**URL**: `/marcas/batch`

**Método**: `POST`

**Corpo da Requisição**:

```json
[
  {
    "nome": "Honda",
    "codigoDenatran": "1234567895432654321",
    "ativo": true
  },
  {
    "nome": "Honda",
    "codigoDenatran": "1234567895432654321",
    "ativo": true
  },
  {
    "nome": "Honda",
    "codigoDenatran": "1234567895432654321",
    "ativo": true
  }
]
```

**Resposta de Sucesso**:

- **Código**: 201

### Retorna Lista de Marcas

**URL**: `/marcas`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json
[
  {
    "id": 1,
    "codigoDenatran": "1234567895432654321",
    "nome": "Honda",
    "ativo": true,
    "modelos": [
      {
        "id": 1,
        "nome": "Civic",
        "ano": "2023",
        "ativo": true
      }
    ]
  }
]
```

### Retorna Marca pelo ID

**URL**: `/marcas/{id}`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json
{
  "id": 2,
  "codigoDenatran": "1234567895432654321",
  "nome": "Fiat",
  "ativo": false,
  "modelos": []
}
```

### Retorna Marca pelo Nome

**URL**: `/marcas/find?nome={nome}`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json

  {
    "id": 1,
    "codigoDenatran": "123456789987654321",
    "nome": "Volkswagen",
    "ativo": true,
    "modelos": []
  }

```

### Atualizar Marca

**URL**: `/marcas`

**Método**: `PUT`


  **Corpo da Requisição**:
```json
{
  "id": 1,
  "codigoDenatran": "1234567895432654321",
  "nome": "HondaTeste",
  "ativo": false
}

```
**Resposta de Sucesso**:

- **Código**: 204

### Deletar Marca

**URL**: `/marcas/{id}`

**Método**: `DELETE`

**Resposta de Sucesso**:

- **Código**: 204

***
## Endpoint Modelos

### Criar Modelo

**URL**: `/modelos`

**Método**: `POST`

**Corpo da Requisição**:

```json
{
  "nome": "Civic",
  "ano": "2023",
  "ativo": true,
  "marcaId": 1
}
```

**Resposta de Sucesso**:

- **Código**: 201

- **Conteúdo**:
```json
{
  "id": 2,
  "nome": "Civic",
  "ano": "2023",
  "ativo": true
}
```
### Criar Vários Modelos

**URL**: `/modelos/batch`

**Método**: `POST`

**Corpo da Requisição**:

```json
[
  {
    "nome": "Civics",
    "ano": "2023",
    "ativo": true,
    "marcaId": 3
  },
  {
    "nome": "Civics",
    "ano": "2023",
    "ativo": true,
    "marcaId": 3
  }
]
```

**Resposta de Sucesso**:

- **Código**: 201

### Retorna Lista de Modelos

**URL**: `/modelos`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json
{
  "id": 1,
  "nome": "Civic",
  "ano": "2023",
  "ativo": true
}
```

### Retorna Modelo pelo ID

**URL**: `/modelos/{id}`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json
{
  "id": 8,
  "nome": "Civicc",
  "ano": "2023",
  "ativo": true
}
```

### Retorna Modelo pelo Nome

**URL**: `/modelos/find?nome={nome}`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json
{
  "id": 1,
  "nome": "Civic",
  "ano": "2023",
  "ativo": true
}

```


### Atualizar Modelo

**URL**: `/modelos`

**Método**: `PUT`


**Corpo da Requisição**:
```json
{
  "id": 4,
  "nome": "CivicTeste",
  "ano": "2023",
  "ativo": true
}

```
**Resposta de Sucesso**:

- **Código**: 204

### Deletar Modelo

**URL**: `/modelos/{id}`

**Método**: `DELETE`

**Resposta de Sucesso**:

- **Código**: 204

***
## Endpoint MarcaModelo
### Retorna todos os modelos associados a determinada Marca

**URL**: `/marcasmodelos/{id}`

**Método**: `GET`

**Resposta de Sucesso**:

- **Código**: 200
- **Conteúdo**:
```json
[
  {
    "id": 1,
    "nome": "Civic",
    "ano": "2023",
    "ativo": true
  },
  {
    "id": 2,
    "nome": "Civic",
    "ano": "2023",
    "ativo": true
  },
  {
    "id": 3,
    "nome": "Civic",
    "ano": "2023",
    "ativo": true
  }
]
```
***