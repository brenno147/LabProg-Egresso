import React from "react";


function DepoimentoTextComponent(props){
    return(
        <div style={{backgroundColor: "transparent", width:"100%"}}>
            <textarea className="w-100" wrap="hard" name={props.inputName} value = {props.inputValue} onChange = {props.inputChange} type="text"></textarea>
        </div>
    );
}

export default DepoimentoTextComponent