import React from 'react'
import {faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function Cargo(props){
    return(
        <>
            <input type="text" className="input-text w-50" placeholder={props.cargo}/>
            <div className="row justify-content-evenly w-50">
                <div className="col"><input type="text" className="input-text" placeholder={props.descricao}/></div>
                <div className="col-1 ml-5" > <button className="depoimento-btn"><FontAwesomeIcon icon={faTrash} className="icon"/></button></div>
            </div>
        </>
    );
}

export default Cargo;