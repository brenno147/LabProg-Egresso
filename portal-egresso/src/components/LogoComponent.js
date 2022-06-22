import React from "react";
import logo from '../imgs/logo_size.jpg'
function LogoComponent(){
    return(
        <div className="container mt-5">
            <div className="row justify-align-center"> 
                <img src={logo} alt="logo"/>
            </div>
        </div>
    );
}

export default LogoComponent