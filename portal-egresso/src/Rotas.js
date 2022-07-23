import React from 'react';

import {Route, Routes, HashRouter} from 'react-router-dom';

import Home from './pages/Home';
import EgressoPage from './pages/EgressoPage';
import Estatisticas from './pages/Estatisticas';
import Depoimento from './pages/Depoimentos';
import Cadastro from './pages/Cadastro';
import Login from './pages/Login';
import Perfil from './pages/Perfil';
import EditarPerfil from './pages/EditarPerfil';

function Rotas() {
    return (
        <HashRouter>
            <Routes>
                <Route path="/" element={<Home/>} exact/> 
                <Route path="/home" element={<Home/>} exact/>
                <Route path="/estatisticas" element={<Estatisticas/>} exact/>
                <Route path="/egresso" element={<EgressoPage/>} exact/>
                <Route path="/depoimento" element={<Depoimento/>} exact/>
                <Route path="/login" element={<Login/>} exact/>
                <Route path="/cadastro" element={<Cadastro/>} exact/>
                <Route path="/perfil" element={<Perfil/>} exact/>
                <Route path="/editarperfil" element={<EditarPerfil/>} exact/>
            </Routes>
        </HashRouter>
    );
}

export default Rotas