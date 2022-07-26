import React, { useState } from "react";
import LogoComponent from "../components/LogoComponent";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import Footer from "../components/Footer";
import LoginService from "../services/LoginService";
import {useNavigate} from "react-router-dom";
import constantes from "../Constantes";
import { Alert } from "react-bootstrap";

function Login(){
    const [invalidText, setInvalidText] = useState(false);
    const navigate = useNavigate();
    const service = new LoginService();
    function cadastrarUsuario(e) {
        e.preventDefault()
        service.fazerLogin(email,senha).then((dados) =>{
            console.log("Respo",dados);
            if (dados !== ""){
                constantes.logado = true;
                constantes.token = dados.data;
                var objeto = JSON.parse(dados.config.data);
                constantes.email = objeto["email"]
                // console.log(constantes.email);
                navigate("/home");
            }else{
                setInvalidText("Verifique suas credenciais");
            }
        }) 
    }

    const [email, setEmail] = useState('')
    const [senha, setSenha] = useState('')

    return(
        <div>
            <NavbarComponentLogin/>
            {invalidText && (
                <div className="sticky-top">
                <Alert
                    variant="danger"
                    onClose={() => setInvalidText(false)}
                    dismissible
                >
                    {invalidText}
                </Alert>
                </div>
            )}
            <div className="d-flex flex-column align-items-center">
                <div className="justify-align-center d-flex">
                    <LogoComponent/>
                </div>
                <div style={{width:"20%", marginTop:"50px", marginBottom:"50px"}}>
                    <form onSubmit={cadastrarUsuario}>
                        <div>
                            <label className="textInput">Email:</label>
                            <br></br>
                            <input type="text" className="login-input" placeholder="Digite seu email" value={email} onChange={(e)=> setEmail(e.target.value)}/>
                        </div>
                        <div style={{marginTop:"15px"}}>
                            <label className="textInput">Senha:</label>
                            <br></br>
                            <input type="password" className="login-input" placeholder="Digite sua senha" value={senha} onChange={(e)=> setSenha(e.target.value)}/>
                        </div>
                        <div style={{ marginTop:"50px", marginBottom:"50px"}}>
                            <div className='button-style-hover'>
                                <button  className="button-style" type="submit">Login</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <Footer/>
        </div>
    );
}



export default Login
