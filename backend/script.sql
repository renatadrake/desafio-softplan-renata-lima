CREATE TABLE clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    limite INTEGER NOT NULL,
    saldo INTEGER DEFAULT 0
);

CREATE TABLE transacoes (
    id SERIAL PRIMARY KEY,
    valor INTEGER NOT NULL,
    tipo CHAR(1) NOT NULL,
    descricao VARCHAR(10) NOT NULL,
    realizada_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    cliente_id INTEGER REFERENCES clientes(id) ON DELETE CASCADE
);

-- clientes iniciais
INSERT INTO clientes (nome, limite, saldo) VALUES
('Cliente 1', 100000, 0),
('Cliente 2', 80000, 0),
('Cliente 3', 1000000, 0),
('Cliente 4', 10000000, 0),
('Cliente 5', 500000, 0);
