
# 🏛️ Desafio Técnico Softplan - Gestão Pública Ambiental - 2024

Este projeto é uma aplicação Full Stack desenvolvida para gerenciar transações financeiras de clientes, simulando cenários reais de gestão pública. Com uma API robusta e um frontend elegante, o sistema atende aos requisitos descritos no desafio técnico, incluindo funcionalidades como criação de transações e consulta de extratos.

---

## 📋 Funcionalidades

### **Backend**
- **Rotas:**
  - `POST /clientes/{id}/transacoes`: Criação de transações (recebíveis e débitos) para um cliente específico.
  - `GET /clientes/{id}/extrato`: Consulta do saldo atual e das últimas transações de um cliente.
- **Regras de Negócio:**
  - Validação de limites para transações de débito.
  - Verificação de campos obrigatórios no payload.
  - Retorno apropriado de erros (404, 422).
  
### **Frontend**
- **Rotas:**
  - `/transacoes`: Tela para gerar novas transações.
  - `/extrato`: Tela para visualizar o extrato e as últimas transações.
- **Design Elegante:**
  - Interface moderna utilizando Material-UI.
  - Tons de azul para um visual limpo e profissional.

### **Infraestrutura**
- **Banco de Dados:**
  - Utilização de PostgreSQL com script de inicialização (`script.sql`).
- **Load Balancer:**
  - Configurado com HAProxy para distribuir requisições entre múltiplas instâncias do backend.
- **Docker Compose:**
  - Gerenciamento completo de contêineres (frontend, backend, banco de dados e balanceador).

---

## 🛠️ Tecnologias Utilizadas

### **Backend**
- Java 17 com Spring Boot
- PostgreSQL
- Maven

### **Frontend**
- React com TypeScript
- Material-UI (MUI)

### **Infraestrutura**
- Docker e Docker Compose
- HAProxy

---

## 📂 Estrutura do Projeto

```plaintext
desafio-softplan
├── backend
│   ├── src/main/java       # Código-fonte do backend
│   ├── src/main/resources  # Configuração e script SQL
│   ├── Dockerfile          # Dockerfile do backend
│   ├── pom.xml             # Configuração do Maven
│   └── script.sql          # Script de inicialização do banco
├── frontend
│   ├── src                 # Código-fonte do frontend
│   ├── public              # Arquivos estáticos
│   ├── Dockerfile          # Dockerfile do frontend
│   ├── package.json        # Dependências do Node.js
│   └── tsconfig.json       # Configuração do TypeScript
├── docker-compose.yml      # Configuração dos contêineres
└── haproxy.cfg             # Configuração do Load Balancer
```

---

## 🖥️ Como Rodar o Projeto

### **Pré-requisitos**
- [Docker](https://www.docker.com/products/docker-desktop) instalado.
- [Docker Compose](https://docs.docker.com/compose/) configurado.

### **Passos**
1. Clone este repositório:
   ```bash
   git clone https://seu-repositorio-git.git
   cd desafio-softplan
   ```

2. Suba os contêineres:
   ```bash
   docker-compose up --build
   ```

3. Acesse as aplicações:
   - **Frontend:** `http://localhost:3000`
   - **Load Balancer (Backend):** `http://localhost:9999`

---

## 📊 Testes

### **1. Endpoint de Transações**
Crie uma transação:
```bash
curl -X POST http://localhost:9999/clientes/1/transacoes -H "Content-Type: application/json" -d '{
    "valor": 1000,
    "tipo": "r",
    "descricao": "Teste"
}'
```

### **2. Endpoint de Extrato**
Consulte o extrato de um cliente:
```bash
curl -X GET http://localhost:9999/clientes/1/extrato
```

---

## 📄 Licença

Este projeto segue a licença MIT.

---

## 💻 Desenvolvido por

**Renata Lima Ferreira**  
Criado com 💙 e dedicação para o desafio técnico da Softplan.
