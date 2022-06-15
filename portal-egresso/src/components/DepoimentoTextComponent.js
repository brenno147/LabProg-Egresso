import React from "react";
import {faTrash } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

function DepoimentoTextComponent(){
    return(
        <div className="">
            <textarea wrap="hard" className="depoimento"></textarea>
            <button class="depoimento-btn"><FontAwesomeIcon icon={faTrash} className="icon"/></button>
        </div>
    );
}

export default DepoimentoTextComponent