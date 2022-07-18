import React from 'react';
import {Navbar,Nav,Container} from 'react-bootstrap';
import { useNavigate } from 'react-router-dom';
import ButtonComponent from './ButtonComponent';
import logo from '../imgs/log.png';
import '../css/style.css';
import constantes from "../Constantes";
import {faUser, faRightFromBracket} from "@fortawesome/free-solid-svg-icons"
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function NavbarComponent(){
    console.log("Login:",constantes.logado)
    const navigate = useNavigate()
    function logout(){
        constantes.logado = false;
        navigate("/home");
    }
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
                {!constantes.logado && (
                    <div className="button-nav">
                        <ButtonComponent nome={'Cadastre-se'} click={() => navigate('/cadastro')}/>
                    </div>
                )}
                {!constantes.logado && (
                    <div className="button-nav">
                        <ButtonComponent nome={'Login'} click={() => navigate('/login')}/>
                    </div>
                )}
                {constantes.logado && (
                    <div className="button-nav">
                        <button className="depoimento-btn" onClick={() => navigate('/perfil')}>
                            <FontAwesomeIcon icon={faUser} style={{height:"18px", width:"40px", color:"white"}}/>
                        </button>
                    </div>
                )}
                {constantes.logado && (
                    <div className="button-nav">
                        <button className="depoimento-btn" onClick={() => logout()}>
                            <FontAwesomeIcon icon={faRightFromBracket} style={{height:"18px", width:"40px", color:"white"}}/>
                        </button>
                    </div>
                )}
                </Navbar.Collapse>
            </Container>   
        </Navbar>
    );
}

export default NavbarComponent