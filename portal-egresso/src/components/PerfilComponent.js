import React from "react";
import perfil from "../imgs/perfil.png";
import {faEdit, faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function PerfilComponent(){
    return(
        <div>
            <div className="perfil">
                <div className="row justify-content-center align-items-center">
                    <img src={perfil}></img>
                </div>
            </div>
            <button className="depoimento-btn"><FontAwesomeIcon icon ={faEdit} className="icon-perfil"/></button>
        </div>
    );
}

export default PerfilComponent