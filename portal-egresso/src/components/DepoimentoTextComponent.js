import React from "react";
import {faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function DepoimentoTextComponent(props){
    return(
        <div style={{alignItems: "flex-start", display: "flex", backgroundColor: "transparent", width:"40%"}}>
            <textarea wrap="hard" className="depoimento"></textarea>
            <button className="depoimento-btn" style={{alignSelf:"end"}}><FontAwesomeIcon icon={faTrash} className="icon"/></button>
        </div>
    );
}

export default DepoimentoTextComponent