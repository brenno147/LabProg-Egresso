import React from 'react';

import {Route, Routes, HashRouter} from 'react-router-dom';

import Home from './pages/Home';
import EgressoPage from './pages/EgressoPage';
import Egresso from './pages/Egresso';
import Estatisticas from './pages/Estatisticas';
import Depoimento from './pages/Depoimentos';
import Cadastro from './pages/Cadastro';
import Login from './pages/Login';
import Perfil from './pages/Perfil';


function Rotas() {
    return (
        <HashRouter>
            <Routes>
                <Route path="/" element={<Home/>} exact/> 
                <Route path="/home" element={<Home/>} exact/>
                <Route path="/estatisticas" element={<Estatisticas/>} exact/>
                <Route path="/egresso" element={<Egresso/>} exact/>
                <Route path="/depoimento" element={<Depoimento/>} exact/>
                <Route path="/login" element={<Login/>} exact/>
                <Route path="/cadastro" element={<Cadastro/>} exact/>
                <Route path="/perfil" element={<Perfil/>} exact/>
            </Routes>
        </HashRouter>
    );
}

export default Rotas