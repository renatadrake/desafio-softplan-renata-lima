# Utilizar uma imagem Node.js leve
FROM node:16-alpine

# Diretório de trabalho dentro do container
WORKDIR /app

# Copiar arquivos de dependência para o container
COPY package.json yarn.lock ./

# Instalar as dependências
RUN yarn install

# Copiar todos os arquivos do projeto
COPY . .

# Expor a porta padrão do React
EXPOSE 3000

# Comando para iniciar a aplicação
CMD ["yarn", "start"]
