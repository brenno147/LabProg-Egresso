import React from "react";
import LogoComponent from "../components/LogoComponent";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import FooterComponent from "../components/FooterComponent";
import InputLoginComponent from "../components/InputLoginComponent";
import ButtonComponent from "../components/ButtonComponent";



function Login(){
    return(
        <div>
            <NavbarComponentLogin/>
            <div className="center-text-login">
                <LogoComponent/>
                <InputLoginComponent value="E-mail"/>
                <InputLoginComponent value="Senha"/>
            </div>
            <div className="button-login">
                <ButtonComponent value="Login"/>
            </div>
            <FooterComponent/>
        </div>
    );
}


export default Login
