import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Transacoes from './pages/Transacoes';
import Extrato from './pages/Extrato';

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/transacoes" element={<Transacoes />} />
                <Route path="/extrato" element={<Extrato />} />
            </Routes>
        </Router>
    );
};

export default App;
