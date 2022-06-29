import React from 'react';

import {Route, Routes, HashRouter} from 'react-router-dom';

import Home from './pages/Home';
import EgressoPage from './pages/EgressoPage';
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
                <Route path="/home" element={<Home/>}/>
                <Route path="/estatisticas" element={<Estatisticas/>}/>
                <Route path="/egresso" element={<EgressoPage/>}/>
                <Route path="/depoimento" element={<Depoimento/>}/>
                <Route path="/login" element={<Login/>}/>
                <Route path="/cadastro" element={<Cadastro/>}/>
                <Route path="/perfil" element={<Perfil/>}/>
            </Routes>
        </HashRouter>
    );
}

export default Rotas