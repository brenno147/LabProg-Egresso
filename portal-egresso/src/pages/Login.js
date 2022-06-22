import React from "react";
import LogoComponent from "../components/LogoComponent";
import NavbarComponentLogin from "../components/NavbarComponentLogin";
import Footer from "../components/Footer";
import InputLoginComponent from "../components/InputLoginComponent";
import ButtonComponent from "../components/ButtonComponent";



function Login(){
    return(
        <div>
            <NavbarComponentLogin/>
            <div className="d-flex flex-column align-items-center">
                <div className="justify-align-center d-flex">
                    <LogoComponent/>
                </div>
                <div style={{width:"20%", marginTop:"50px", marginBottom:"50px"}}>
                    <InputLoginComponent value="E-mail"/>
                    <InputLoginComponent value="Senha"/>
                </div>
                <div style={{width:"20%", marginTop:"50px", marginBottom:"50px"}}>
                    <ButtonComponent value="Login"/>
                </div>
            </div>
            <Footer/>
        </div>
    );
}


export default Login
