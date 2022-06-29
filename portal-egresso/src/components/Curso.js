import React from "react";
import {faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function Curso(props){
    return(
        <>
        <input type="text" className="input-text" placeholder={props.curso}/>
        <div className="row justify-content-evenly w-100"> 
            <div className="col-3"><input type="text" className="input-text" placeholder={props.nivel}/></div>
            <div className="col-1 mr-5"><input type="date"></input></div>
            <div className="col-1 ml-5 mr-5"><input type="date"></input></div>
            <div className="col-1 ml-5" > <button className="depoimento-btn"><FontAwesomeIcon icon={faTrash} className="icon"/></button></div>
        </div>
            
        </>
    );
}

export default Curso;