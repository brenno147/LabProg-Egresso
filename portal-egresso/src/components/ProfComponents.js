import React from "react";
import {faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function ProfComponent(props){
    return(
        <div className="input">
            <input type="text" className="input-text" placeholder={props.value}/>
            <button className="depoimento-btn"><FontAwesomeIcon icon={faTrash} className="icon"/></button>
        </div>
    );
}

export default ProfComponent