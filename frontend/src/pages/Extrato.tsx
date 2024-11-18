import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Container, Typography, Paper, List, ListItem, ListItemText, Box } from '@mui/material';

const Extrato = () => {
    const [extrato, setExtrato] = useState<any>(null);

    useEffect(() => {
        const idCliente = localStorage.getItem('idCliente');
        if (idCliente) {
            buscarExtrato(Number(idCliente));
        }
    }, []);

    const buscarExtrato = async (id: number) => {
        try {
            const resposta = await axios.get(`http://localhost:8080/clientes/${id}/extrato`);
            setExtrato(resposta.data);
        } catch (erro) {
            console.error('Erro ao buscar extrato:', erro);
        }
    };

    return (
        <Container maxWidth="md" sx={{ mt: 5 }}>
            <Typography variant="h4" gutterBottom color="primary">
                Extrato de Transações
            </Typography>
            {extrato ? (
                <Paper elevation={3} sx={{ p: 3, mt: 3 }}>
                    <Typography variant="h6">Saldo Atual</Typography>
                    <Typography variant="body1" gutterBottom>
                        <strong>Total:</strong> R$ {extrato.saldo.total / 100} <br />
                        <strong>Data do Extrato:</strong> {new Date(extrato.saldo.data_extrato).toLocaleString()} <br />
                        <strong>Limite:</strong> R$ {extrato.saldo.limite / 100}
                    </Typography>
                    <Typography variant="h6" sx={{ mt: 3 }}>
                        Últimas Transações
                    </Typography>
                    <List>
                        {extrato.ultimas_transacoes.map((t: any, index: number) => (
                            <ListItem key={index} divider>
                                <ListItemText
                                    primary={`${t.tipo.toUpperCase()}: R$ ${t.valor / 100}`}
                                    secondary={`${t.descricao} - ${new Date(t.realizada_em).toLocaleString()}`}
                                />
                            </ListItem>
                        ))}
                    </List>
                </Paper>
            ) : (
                <Box sx={{ textAlign: 'center', mt: 5 }}>
                    <Typography variant="body1" color="secondary">
                        Carregando...
                    </Typography>
                </Box>
            )}
        </Container>
    );
};

export default Extrato;
