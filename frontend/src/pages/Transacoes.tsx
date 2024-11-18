import React from 'react';
import axios from 'axios';
import { Button, Container, Typography, Box } from '@mui/material';

const Transacoes = () => {
    const gerarTransacao = async () => {
        const idCliente = 1; 
        const transacao = {
            valor: Math.floor(Math.random() * 1000) + 1, 
            tipo: 'r', 
            descricao: 'Teste'
        };

        try {
            const resposta = await axios.post(
                `http://localhost:8080/clientes/${idCliente}/transacoes`,
                transacao
            );

            localStorage.setItem('idCliente', idCliente.toString());
            alert('Transação realizada com sucesso!');
        } catch (erro) {
            console.error('Erro ao realizar transação:', erro);
        }
    };

    return (
        <Container maxWidth="sm" sx={{ textAlign: 'center', mt: 5 }}>
            <Typography variant="h4" gutterBottom color="primary">
                Gerar Transações
            </Typography>
            <Typography variant="body1" gutterBottom>
                Clique no botão abaixo para gerar uma nova transação.
            </Typography>
            <Box mt={4}>
                <Button variant="contained" color="primary" onClick={gerarTransacao}>
                    Gerar Transação
                </Button>
            </Box>
        </Container>
    );
};

export default Transacoes;
