import React from "react";

function TextInputComponent(props){
    return(
        <div style={{alignItems: "flex-start",display: "in-line", backgroundColor: "transparent", width:"100%"}}>
            <label className="textInput">{props.value}&nbsp;</label>
            <input name={props.inputName} value = {props.inputValue} onChange = {props.inputChange} type="date"></input>
        </div>
    );
}

export default TextInputComponent