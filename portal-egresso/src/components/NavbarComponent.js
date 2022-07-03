import React from 'react';
import {Navbar,Nav,Container} from 'react-bootstrap';
import ButtonComponent from './ButtonComponent';
import logo from '../imgs/log.png';
import '../css/style.css';

function NavbarComponent(){

    return(
        <Navbar expand="lg" style={{backgroundColor: "#5b7bb5"}}>
            <Container>
                <Navbar.Brand href="#/home">
                    <div className="logo-nav">
                        <img src={logo} alt="logo"/>
                    </div>
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="justify-content-center flex-grow-1 pe-3 text-nav-hover">
                    <a className="text-nav" href="#/home">Home</a>
                    <a className="text-nav" href="#/egresso">Egressos</a>
                    <a className="text-nav" href="#/depoimento">Depoimentos</a>
                    <a className="text-nav" href="#/estatisticas">Estatísticas</a>
                </Nav>
                <div className="button-nav">
                    <ButtonComponent nome={'Cadastre-se'} route={'#/cadastro'}/>
                </div>
                <div className="button-nav">
                    <ButtonComponent nome={'Login'}/>
                </div>
                </Navbar.Collapse>
            </Container>   
        </Navbar>
    );
}

export default NavbarComponent